package br.com.nrsjnet.payment.domain.dto;

public class TicketPaymentDTO {

    private String paymentCode;

    public TicketPaymentDTO(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
