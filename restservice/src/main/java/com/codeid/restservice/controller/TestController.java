package com.codeid.restservice.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Aditya") // parent -->
// @Controller //non rest controller
@RestController
public class TestController {

    @GetMapping(produces = "text/html") // produces = tipenya //semua yang masuk di GET diawali oleh
                                                       // @requestmapping
    public String testGet(@RequestParam("name") String[] names, HttpServletRequest request,
            HttpServletResponse response) {
        Enumeration<String> e = request.getHeaderNames();
        String result = "";
        while (e.hasMoreElements()) {
            String header = e.nextElement();
            String value = request.getHeader(header);
            result += header + ": " + value + "<br>";
        }
        result += "<br>";
        for (String name : names) {
            result += "[GET] <b>hal0000oooooo00ooooo000ooo000ooo0000000000000ooooooo </b>" + name + "<br>";
        }
        return result;
        // response.setContentType(type); //mengatur lower upper dan lain lain
        // response.setStatus(sc); status http code 
        // spring auotomatis set status http code nya menjadi 200
    }

    @PostMapping(produces = "text/html") // semua yang masuk di GET diawali oleh @requestmapping
    public String testPost(@RequestParam String name, @RequestParam("age") int age) {
        return "[POST] <b>haloo </b>" + name + ",your age is: " + age;
    }
}