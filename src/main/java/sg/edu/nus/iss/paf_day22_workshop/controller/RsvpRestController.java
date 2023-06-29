package sg.edu.nus.iss.paf_day22_workshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day22_workshop.model.Error;
import sg.edu.nus.iss.paf_day22_workshop.model.RSVP;
import sg.edu.nus.iss.paf_day22_workshop.service.RSVPService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/api")
public class RsvpRestController {

    @Autowired
    RSVPService svc;
    
    @GetMapping(value="/rsvps", produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<List<RSVP>> getAllRsvps() {
        return ResponseEntity.ok().body(svc.getAllRsvps());
    }

    @GetMapping(value="/rsvp")
    public ResponseEntity<?> getRsvpByName(@RequestParam String q) {
        
        if (svc.getRsvpByName(q).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("No RSVP found with name: " + q));
        }
        return ResponseEntity.ok().body(svc.getRsvpByName(q));
    }
    
    

}
