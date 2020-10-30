package com.fazith.sitemonitor.controller;

import com.fazith.sitemonitor.Constants;
import com.fazith.sitemonitor.SiteMonitorApplication;
import com.fazith.sitemonitor.repository.LocalStore;
import com.fazith.sitemonitor.service.URLStatusCheckService;
import com.fazith.sitemonitor.service.URLValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MonitorController {

    private static final Logger logger = LoggerFactory.getLogger(MonitorController.class);

    @Autowired
    URLStatusCheckService urlStatusCheckService;

    @Autowired
    URLValidatorService urlValidatorService;



    @GetMapping({"/"})
    public String monitor(Model model) throws IOException {
        Map<String,String> monitorstatus = urlStatusCheckService.getStatus();
        model.addAttribute(Constants.MONITOR_STATUS, monitorstatus);
        logger.info(String.valueOf(monitorstatus));
        return "monitor";
    }

    @PostMapping("/")
    public String monitor(HttpServletRequest request, Model model) throws IOException {
        try {
            String newURL = request.getParameter("url");
            logger.info("New URL : "+newURL);
            if (urlValidatorService.validateURL(newURL)) {
                logger.info(newURL+" is a valid URL");
                LocalStore.addtoStore(newURL);
                logger.info(newURL+" added to localstore");
                Map<String, String> monitorstatus = urlStatusCheckService.getStatus();
                model.addAttribute(Constants.MONITOR_STATUS, monitorstatus);
            } else {
                logger.info(newURL+" is not a valid URL");
                Map<String, String> monitorstatus = urlStatusCheckService.getStatus();
                model.addAttribute(Constants.MONITOR_STATUS, monitorstatus);
                model.addAttribute("error", Constants.INVALID_URL_ERROR_MSG);
                logger.info("Returning error");
                logger.info(String.valueOf(monitorstatus));
            }
        } catch (Exception e){
            e.printStackTrace();
            Map<String, String> monitorstatus = urlStatusCheckService.getStatus();
            model.addAttribute(Constants.MONITOR_STATUS, monitorstatus);
            model.addAttribute("error", Constants.INVALID_URL_ERROR_MSG );
            logger.info(String.valueOf(monitorstatus));
        }

        return "monitor";
    }

}
