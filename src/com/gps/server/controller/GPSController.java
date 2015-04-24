package com.gps.server.controller;


import com.gps.server.PMF;
import com.gps.server.model.GPS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Persistent;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by JongHunLee on 2015-04-21.
 */

@Controller
@RequestMapping("/gps")
public class GPSController {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddGPSPage(ModelMap model) {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request, ModelMap model) {

        String userId = request.getParameter("userId");
        String time = request.getParameter("time");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");

        GPS gps = new GPS();
        gps.setUserId(userId);
        gps.setTime(time);
        gps.setLatitude(latitude);
        gps.setLongitude(longitude);

        PersistenceManager pm = PMF.get().getPersistenceManager();

        try {
            pm.makePersistent(gps);
        } finally {
            pm.close();
        }

        return new ModelAndView("redirect:list");
    }

    // get all customers
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listGPS(ModelMap model) {

        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(GPS.class);
        q.setOrdering("userId desc");

        List<GPS> results = null;

        try {
            results = (List<GPS>) q.execute();

            if (results.isEmpty()) {
                model.addAttribute("gpsList", null);
            } else {
                model.addAttribute("gpsList", results);
            }

        } finally {
            q.closeAll();
            pm.close();
        }

        return "list";
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    public String listGPSUserId(@PathVariable String userId, ModelMap model) {
        PersistenceManager pm = PMF.get().getPersistenceManager();

        Query q = pm.newQuery(GPS.class);

        q.setFilter("userId == userIdParameter");
        q.setOrdering("time desc");
        q.declareParameters("String userIdParameter");

        List<GPS> results = null;

        try {
            results = (List<GPS>) q.execute(userId);

            if (results.isEmpty()) {
                model.addAttribute("gpsList", null);
            } else {
                model.addAttribute("gpsList", results);
            }

        } finally {
            q.closeAll();
            pm.close();
        }

        return "list";
    }
}
