package io.github.augustorsn.back_end_baba.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoItensPedidoDTO {

    private String nomeProduto;    
    private Integer quantidade;
    private BigDecimal preçoUnitario; 
    
}
