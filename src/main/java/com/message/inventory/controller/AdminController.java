package com.message.inventory.controller;

import com.message.inventory.model.entity.Admin;
import com.message.inventory.model.DTO.Stock;
import com.message.inventory.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin){
        return adminService.verify(admin);
    }
    @PostMapping("/register")
    public ResponseEntity<?> newAdmin(@RequestBody Admin admin) {
        return adminService.newAdmin(admin);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }
    @PostMapping("/addStoke")
    public ResponseEntity<?> addStock(@RequestBody List<Stock> list) {
        return adminService.addStock(list);
    }

//    @GetMapping("/getCsrf")
//    public org.springframework.security.web.server.csrf.CsrfToken getCsrf(HttpServletRequest request){
//        return (org.springframework.security.web.server.csrf.CsrfToken) request.getAttribute("_csrf");
//    }
//    @GetMapping("/getSession")
//    public String getSession(HttpServletRequest request){
//        return "Hey "+request.getSession().getId();
//    }
}
