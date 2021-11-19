package br.com.hidroponia.hydra.servicos;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.hidroponia.hydra.exceptions.HydraException;


@Documented
@Service
@Transactional
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ServicoTransacional {
	
	Propagation propagation() default Propagation.REQUIRED;

	boolean readOnly() default false;

	Class<? extends Throwable>[] rollbackFor() default { HydraException.class };

	Class<? extends Throwable>[] noRollbackFor() default {};
}