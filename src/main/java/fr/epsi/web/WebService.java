package fr.epsi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.epsi.domain.Concert;
import fr.epsi.domain.Reservation;

@Controller
public class WebService {

    private List<Concert> listConcert = new ArrayList<Concert>();

    // RECCUP LISTE DES CONCERT
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/concert")
    @ResponseBody
    public List<Concert> listerConcert() {
        return listConcert;
    }

    // AJOUTER UN CONCERT
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/concert/")
    @ResponseBody
    public Concert setConcert(@RequestBody Concert c) {
        c.setId(listConcert.size());
        listConcert.add(c);
        return c;
    }

    // RECCUP DETAIL D'UN CONCERT AVEC UN ID
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/concert/{id}")
    @ResponseBody
    public Concert getDetailConcertById(@PathVariable int id) {
        Concert ct = new Concert();
        for (Concert c : listConcert) {
            if (c.getId() == id) {
                ct = c;
                break;
            }
        }
        return ct;
    }

    // TODO METTRE A JOUR UN CONCERT

    // SUPPRIMER UN CONCERT (REQUEST BODY)
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value = "/concert/")
    @ResponseBody
    public int deleteConcert(@RequestBody Concert c) {
        listConcert.remove(c);
        return 201;
    }

    // SUPPRIMER UN CONCERT AVEC UN ID
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value = "/concert/{id}")
    @ResponseBody
    public int deleteConcert(@PathVariable int id) {
        listConcert.remove(id);
        return 201;
    }

    // AJOUTER UNE RESERVATION POUR UN CONCERT
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/concert/{id}")
    @ResponseBody
    public Reservation reserverPlace(@PathVariable int id, @RequestBody Reservation r) {
        Concert concert = this.getDetailConcertById(id);
        return concert.addReservation(r);
    }

    // RECCUP DETAIL D'UNE RESERVATION
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/concert/{idConcert}/{idResa}")
    @ResponseBody
    public Reservation getDetailResaById(@PathVariable int idConcert, @PathVariable int idResa) {
        Concert concert = this.getDetailConcertById(idConcert);
        return concert.getReservationWithId(idResa);
    }

    // METTRE A JOUR UNE RESERVATION
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT, value = "/concert/{idConcert}/{idResa}")
    @ResponseBody
    public Reservation reserverPlace(@PathVariable int idConcert, @PathVariable int idResa, @RequestBody Reservation r) {
        Concert concert = this.getDetailConcertById(idConcert);
        return concert.updateReservation(r);
    }

    // SUPPRIMER UNE RESERVATION
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE, value = "/concert/{idConcert}/{idResa}")
    @ResponseBody
    public int deleteReservation(@PathVariable int idConcert, @PathVariable int idResa) {
        this.getDetailConcertById(idConcert).deleteReservationWithId(idResa);
        return 201;
    }
}