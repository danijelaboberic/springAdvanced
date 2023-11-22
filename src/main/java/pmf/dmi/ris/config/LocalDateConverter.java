package pmf.dmi.ris.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class LocalDateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		LocalDate date = LocalDate.parse(source);
		return date;
	}

}
