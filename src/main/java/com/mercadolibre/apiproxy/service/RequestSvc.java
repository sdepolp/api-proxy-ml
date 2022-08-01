package com.mercadolibre.apiproxy.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestSvc {
    Object getRequest(HttpServletRequest request);
}
