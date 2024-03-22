package com.picsart.java.controller;

import com.picsart.java.dao.BillDAO;
import com.picsart.java.models.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {
    private final BillDAO billingDAO;

    public BillController(BillDAO billingDAO){
        this.billingDAO = billingDAO;
    }

    @GetMapping("/generate/{orderId}")
    public String viewBilling(ModelMap modelMap, @PathVariable("orderId") Long orderId){
        Bill billing = billingDAO.view(orderId);
        modelMap.put("billing",billing);
        return "bill/view";
    }
}
