package com.smoope.sdk.examples.controller;

import com.smoope.sdk.SmoopeClient;
import com.smoope.sdk.objects.collections.SmartConnectPagedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/smart-connects")
public class SmartConnectsController {

    private SmoopeClient smoopeClient;

    @Autowired
    public SmartConnectsController(SmoopeClient smoopeClient) {
        this.smoopeClient = smoopeClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        SmartConnectPagedList smartConnects = smoopeClient.getSmartConnectsList(1, 10);

        model.addAttribute("smartConnects", smartConnects);

        return "smart-connects";
    }
}
