package com.wlh.study.controller;

import com.wlh.study.spring.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {
    @Autowired
    private CRUDService crudService;

    @RequestMapping("/getAll")
    public String getAll(){
        return crudService.getAll();
    }
}
