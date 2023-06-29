package sg.edu.nus.iss.paf_day22_workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day22_workshop.model.RSVP;

@Repository
public class RSVPRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String GET_ALL_RSVPS = "select * from rsvps";
    private final String GET_RSVP_BY_NAME = "select * from rsvps where full_name = ?";
    

    public List<RSVP> getAllRsvps(){
        return jdbcTemplate.query(GET_ALL_RSVPS, BeanPropertyRowMapper.newInstance(RSVP.class));
    }

    public List<RSVP> getRsvpByName(String name){
        return jdbcTemplate.query(GET_RSVP_BY_NAME, BeanPropertyRowMapper.newInstance(RSVP.class), name);
    }
}
