package br.com.nrsjnet.payment.domain.dto;

import java.math.BigDecimal;

public class PaymentRequestDTO {

    private String uuidAccount;
    private String uuidClient;
    private String description;
    private BigDecimal value;

    public String getUuidAccount() {
        return uuidAccount;
    }

    public void setUuidAccount(String uuidAccount) {
        this.uuidAccount = uuidAccount;
    }

    public String getUuidClient() {
        return uuidClient;
    }

    public void setUuidClient(String uuidClient) {
        this.uuidClient = uuidClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
