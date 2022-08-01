package com.mercadolibre.apiproxy.service.impl;

import com.mercadolibre.apiproxy.client.ApiClient;
import com.mercadolibre.apiproxy.dto.AuditRequestDto;
import com.mercadolibre.apiproxy.service.RequestSvc;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class requestSvcImpl implements RequestSvc {
    private final ApiClient apiClient;

    public requestSvcImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Object getRequest(HttpServletRequest request) {
        try {
            String URI = request.getRequestURI();
            String IpAddress = request.getRemoteAddr();
            AuditRequestDto auditRequestDto = new AuditRequestDto();
            auditRequestDto.setIp(IpAddress);
            auditRequestDto.setPath(URI);
            Object res = apiClient.getApiML(URI);
            auditRequestDto.setStatusCode(200);
            //TODO save object auditRequestDto to a non relational DB

            return res;
        }catch (Exception e){
            return e;
        }
    }
}
