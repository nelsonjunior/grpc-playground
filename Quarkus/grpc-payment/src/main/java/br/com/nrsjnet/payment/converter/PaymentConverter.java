package br.com.nrsjnet.payment.converter;

import br.com.nrsjnet.payment.domain.dto.PaymentRequestDTO;

import java.math.BigDecimal;

public final class PaymentConverter {

    public static PaymentRequestDTO from(br.com.nrsjnet.grpc.PaymentRequest p){
        return new PaymentRequestDTO(p.getUuidAccountPayment(), p.getUuidClient(), p.getDescription(), BigDecimal.valueOf(p.getValue()));
    }
}
