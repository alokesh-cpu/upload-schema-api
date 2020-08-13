package com.allstate.pmp.schema.transportation.uploadschemaapi.controller;
import com.allstate.pmp.schema.transportation.uploadschemaapi.utils.AppConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = AppConstants.INDEX_PAGE_URI, method = RequestMethod.GET)
    public String indexPage() {
        return AppConstants.INDEX_PAGE;
    }
}
