package pmf.dmi.ris.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LongRunningService {
	
	@Cacheable("pi")
	public double timeConsumingMethod() {
		//TODO implementacija algoritma kome treba puno vremena
		//Simuliramo vreme izvrsavanja tako sto uspavamo nit na 10s
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Math.PI;
	}

}
