package br.com.home.financas.infra;

import java.util.UUID;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import br.com.home.financas.exception.FinancasThrowable;

@Aspect
@Component
public class FinancasLogger {

	@Value("${log.financas.all.method}")
	private String isLogFinancasAllMethod;

	@Around("execution(* br.com.kroton.financas.receiver.*.*(..)) || execution(* br.com.kroton.financas.receiver.model*.*(..))")
	public Object logMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
		ThreadContext.put("callId", UUID.randomUUID().toString());
		Object retorno = null;
		if (Boolean.parseBoolean(isLogFinancasAllMethod)) {
			final Class<?> targetClass = joinPoint.getTarget().getClass();
			final LogFinancas logFinancas = new LogFinancas(targetClass.getSimpleName());
			final String metodo = joinPoint.getSignature().getName();
			try {
				logFinancas.info(getMetodoEntrada(metodo, joinPoint.getArgs()), " Inicio");
				final StopWatch stopWatch = new StopWatch();
				stopWatch.start();
				retorno = joinPoint.proceed();
				stopWatch.stop();
				logFinancas.info(metodo, " Duração : " + stopWatch.getTotalTimeSeconds() + " seg. Fim ");
			} catch (Exception e) {
				logFinancas.error(metodo, e.getMessage());
				throw new FinancasThrowable(e);
			}
		} else {
			retorno = joinPoint.proceed();
		}
		ThreadContext.clearMap();
		return retorno;

	}

	private String getMetodoEntrada(String metodo, Object[] argumentos) {
		final StringBuilder builder = new StringBuilder();
		builder.append(metodo);
		builder.append(" (");
		setArgumentos(builder, argumentos);
		builder.append(")");
		return builder.toString();
	}

	private void setArgumentos(final StringBuilder builder, final Object[] argumentos) {
		for (int i = 0; i < argumentos.length; i++) {
			if (i != 0) {
				builder.append(", ");
			}
			
			Object arg = argumentos[i];
			builder.append((arg != null) ? argumentos[i].toString() : argumentos[i]);
		}
	}
	
}
