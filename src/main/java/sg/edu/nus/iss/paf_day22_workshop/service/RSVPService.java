package sg.edu.nus.iss.paf_day22_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day22_workshop.model.RSVP;
import sg.edu.nus.iss.paf_day22_workshop.repo.RSVPRepo;

@Service
public class RSVPService {
    
    @Autowired
    RSVPRepo repo;

    public List<RSVP> getAllRsvps(){
        return repo.getAllRsvps();
    }

    public List<RSVP> getRsvpByName(String name){
        return repo.getRsvpByName(name);
    }
}
