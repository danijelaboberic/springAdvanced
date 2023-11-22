package pmf.dmi.ris.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimerService {
	
	@Scheduled(fixedRate = 5000)
	public void repeatSomething() {
		System.out.println("Tajmer je trigerovan...");
		//TODO implementacija neke poslovne logike
	}

}
