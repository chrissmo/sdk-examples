package com.smoope.sdk.examples.controller;

import com.smoope.sdk.SmoopeClient;
import com.smoope.sdk.objects.collections.UserPagedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customers")
public class CustomersController {

    private SmoopeClient smoopeClient;

    @Autowired
    public CustomersController(SmoopeClient smoopeClient) {
        this.smoopeClient = smoopeClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        UserPagedList customers = smoopeClient.getCustomersList(1, 10);

        model.addAttribute("customers", customers);

        return "customers";
    }
}
