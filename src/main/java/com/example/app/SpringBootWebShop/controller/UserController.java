package com.example.app.SpringBootWebShop.controller;

import com.example.app.SpringBootWebShop.service.User.UserOrderService;
import com.example.app.SpringBootWebShop.service.User.UserFruitService;
import com.example.app.SpringBootWebShop.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER =
            Logger.getLogger(UserController.class.getName());

    @Autowired
    UserFruitService userFruitService;
    @Autowired
    UserCapService userCapService;
    @Autowired
    UserOrderService userOrderService;

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Web Shop");
        model.addAttribute("fragmentName", "home");
        return "User/layout";
    }

    @GetMapping("/t-shirts")
    public String getTShirts(Model model) {
        model.addAttribute("title", "T-Shirts");
        model.addAttribute("tShirts", userFruitService.getAll());
        model.addAttribute("fragmentName", "t_shirts");
        return "User/layout";
    }

    @GetMapping("/caps")
    public String getCaps(Model model) {
        model.addAttribute("title", "Caps");
        model.addAttribute("caps", userCapService.getAll());
        model.addAttribute("fragmentName", "caps");
        return "User/layout";
    }

    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("title", "Contacts");
        model.addAttribute("fragmentName", "contacts");
        return "User/layout";
    }

    @PostMapping("/order")
    public ResponseEntity<?> makeOrder(
            @RequestParam("userName") String userName,
            @RequestParam("userPhone") String userPhone,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userOrderMsg") String userOrderMsg) {
        String[] data = new String[]{userName, userPhone,
                userEmail, userOrderMsg};
        // Check data in logs
        LOGGER.info("User order data: " + Arrays.toString(data));
        ResponseEntity<?> response;
        try {
            response = userOrderService.makeOrder(data);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage(false,
                    "Error :("), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
