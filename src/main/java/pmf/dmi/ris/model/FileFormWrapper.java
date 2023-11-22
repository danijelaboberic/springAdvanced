package pmf.dmi.ris.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileFormWrapper implements Serializable {

	private String fileName;
	private LocalDate uploadDate;
	private MultipartFile file;
	
}
