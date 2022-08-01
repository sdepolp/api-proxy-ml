package com.mercadolibre.apiproxy.controller;

import com.mercadolibre.apiproxy.service.RequestSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ApiProxyController {

    private final RequestSvc requestSvc;

    @Autowired
    public ApiProxyController(RequestSvc requestSvc) {
        this.requestSvc = requestSvc;
    }

    @RequestMapping(value = "/**", method = GET)
    public Object getRequest(HttpServletRequest request ){
        return requestSvc.getRequest(request);
    }
}
