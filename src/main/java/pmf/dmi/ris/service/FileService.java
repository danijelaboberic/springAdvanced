package pmf.dmi.ris.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pmf.dmi.ris.model.FileFormWrapper;

@Service
public class FileService {
	
	@Value("${filePath}")
	String filePath;
	
	@Autowired
	EmailService emailService;
	
    public boolean saveToFileSystem(FileFormWrapper fileWrapper) {
		MultipartFile file = fileWrapper.getFile();
		if (null != file) {
 			String fileName = file.getOriginalFilename();
			try {
				File directory = new File(filePath);
			    if (! directory.exists()){
			        directory.mkdirs();
			    }

				File imageFile = new File(filePath, fileName);      
				file.transferTo(imageFile);
				emailService.sendEmailWithAttachment("dboberic@uns.ac.rs", "danijela@ris", "file upload", "Imate novi fajl na serveru.", imageFile);
			
			    return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}  
		}else {
			return false;
		}
    }
    
	public byte[] getPicture(String fileName) {
		byte [] slika = null;
		try {	
			//TODO: popraviti da cita iz baze. Potrebno je da se koristi Blob tip za kolonu a 
			//JPA entitet ce imati property tipa byte[] i anotaciju @Lob
			
			slika = Files.readAllBytes(Paths.get(filePath+"/"+fileName));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return slika;

	}
}
