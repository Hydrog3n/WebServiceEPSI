package fr.epsi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.epsi.domain.Concert;
import fr.epsi.domain.Reservation;

@Controller
public class WebService {
	
	@RequestMapping(method=RequestMethod.GET, value="/concert")
	@ResponseBody
	public List<Concert> listerConcert(){
		System.out.println("méthode: listerConcert");
		ArrayList<Concert> concerts = new ArrayList<Concert>();
		Concert concert = new Concert(10, "Bruno Mars", "Paris");
		concerts.add(concert);
		return concerts;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/concert/{idConcert}")
	@ResponseBody
	public int choisirPlace(@PathVariable(name="idConcert") int id, @RequestBody Reservation reservation){
		System.out.println("methode: choisirPlace, concert: " + id + ", reservation: " + reservation);
		return 0;
	}

}
