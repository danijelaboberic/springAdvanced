package pmf.dmi.ris.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import pmf.dmi.ris.model.FileFormWrapper;
import pmf.dmi.ris.service.EmailService;
import pmf.dmi.ris.service.FileService;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	EmailService emailService;
	
	@ModelAttribute ("fileWrapper")
	public FileFormWrapper getFileWrapper() {
		return new FileFormWrapper();
	}
	
	@GetMapping
	public String homePage() {
		return "file";
	}

	@PostMapping("/upload")
	public String uploadFile(@ModelAttribute("fileWrapper") FileFormWrapper fileWrapper, Model model) {
	   boolean ok = fileService.saveToFileSystem(fileWrapper);
	   if(ok) {
		   model.addAttribute("message", "Fajl je uspešno sačuvan.");
		   emailService.sendEmail("dboberic@uns.ac.rs", "danijela@ris", "file upload", "Imate novi fajl na serveru.");

		   return "file";
	   }else {
		   return "error";

	   }

	}
	
	@GetMapping(value = "show/{fileName}")
	public void getPicture(@PathVariable("fileName") String fileName, HttpServletResponse response) {
		byte[] slika = fileService.getPicture(fileName);
		if (slika != null) {
			try {
				response.getOutputStream().write(slika);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}
}
