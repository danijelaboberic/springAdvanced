package pmf.dmi.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pmf.dmi.ris.service.LongRunningService;

@Controller
@RequestMapping("/math")
public class ComputingController {
	
	@Autowired
	LongRunningService computingService;
	@GetMapping("/pi")
	public String computePi(Model model) {
		double pi =  computingService.timeConsumingMethod();
		model.addAttribute("pi", pi);
		return "computing";
	}

}
