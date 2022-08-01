package com.mercadolibre.apiproxy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuditRequestDto {
    private String ip;
    private String path;
    private int statusCode;
}
