package com.smoope.sdk.examples.controller;

import com.smoope.sdk.SmoopeClient;
import com.smoope.sdk.objects.collections.CustomerIndexList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConversationsController {

    private SmoopeClient smoopeClient;

    @Autowired
    public ConversationsController(SmoopeClient smoopeClient) {
        this.smoopeClient = smoopeClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        CustomerIndexList customers = smoopeClient.getCustomersIndex();

        model.addAttribute("customers", customers);

        return "conversations";
    }
}
