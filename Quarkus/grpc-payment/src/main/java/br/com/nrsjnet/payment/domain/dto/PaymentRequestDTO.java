package br.com.nrsjnet.payment.domain.dto;

import java.math.BigDecimal;

public class PaymentRequestDTO {

    private String uuidAccount;
    private String uuidClient;
    private String description;
    private BigDecimal value;

    public PaymentRequestDTO(String uuidAccount, String uuidClient, String description, BigDecimal value) {
        this.uuidAccount = uuidAccount;
        this.uuidClient = uuidClient;
        this.description = description;
        this.value = value;
    }

    public String getUuidAccount() {
        return uuidAccount;
    }

    public String getUuidClient() {
        return uuidClient;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

}
