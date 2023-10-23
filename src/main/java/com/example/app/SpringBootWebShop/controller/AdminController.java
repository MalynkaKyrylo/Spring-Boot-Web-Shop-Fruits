package com.example.app.SpringBootWebShop.controller;

import com.example.app.SpringBootWebShop.service.Admin.AdminOrderService;
import com.example.app.SpringBootWebShop.service.Admin.AdminFruitService;
import com.example.app.SpringBootWebShop.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER =
            Logger.getLogger(AdminController.class.getName());

    @Autowired
    AdminFruitService adminFruitService;
    @Autowired
    AdminCapService adminCapService;
    @Autowired
    AdminOrderService adminOrderService;

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("title", "Web Shop");
        model.addAttribute("fragmentName", "home");
        return "Admin/layout";
    }

    @GetMapping("/t-shirts")
    public String getTShirts(Model model) {
        model.addAttribute("title", "T-Shirts");
        model.addAttribute("tShirts", adminFruitService.getAll());
        model.addAttribute("fragmentName", "t_shirts");
        return "Admin/layout";
    }

    @GetMapping("/caps")
    public String getCaps(Model model) {
        model.addAttribute("title", "Caps");
        model.addAttribute("caps", adminCapService.getAll());
        model.addAttribute("fragmentName", "caps");
        return "Admin/layout";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("title", "Orders");
        model.addAttribute("orders", adminOrderService.getAll());
        model.addAttribute("fragmentName", "orders");
        return "Admin/layout";
    }

    @PostMapping("/create-cap")
    public ResponseEntity<?> createCap(
            @RequestParam("capName") String capName,
            @RequestParam("capArt") String capArt,
            @RequestParam("capDescr") String capDescr,
            @RequestParam("capPrice") String capPrice,
            @RequestParam("capFile") MultipartFile capFile ) {
        String fileName = capFile.getOriginalFilename();
        String[] data = new String[]{capName, capArt, capDescr,
                capPrice, fileName};
        // Check data in logs
        LOGGER.info("Admin add cap data: " + Arrays.toString(data));
        ResponseEntity<?> response;
        try {
            response = adminCapService.addCap(data, capFile);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(false,
                    "Error :("), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
