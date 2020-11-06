package br.com.nrsjnet.payment.service;

import br.com.nrsjnet.payment.domain.dto.PaymentRequestDTO;
import br.com.nrsjnet.payment.domain.entity.Account;
import br.com.nrsjnet.payment.domain.entity.Client;
import br.com.nrsjnet.payment.domain.entity.Payment;
import br.com.nrsjnet.payment.exception.PaymentException;
import org.bson.types.Decimal128;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApplicationScoped
public class ValidatePaymentService {

    public Payment validate(PaymentRequestDTO dto) throws PaymentException {

        if(dto.getValue().compareTo(BigDecimal.ZERO) < 1){
            throw new PaymentException("Value must be greater than zero!");
        }

        Account account = Account.find("uuid", dto.getUuidAccount()).firstResult();

        if(account == null){
            throw new PaymentException("Account not found!");
        }

        Client client = Client.find("uuid", dto.getUuidClient()).firstResult();

        if(client == null){
            throw new PaymentException("Client not found!");
        }

        if(account.getActualBalance().bigDecimalValue().compareTo(dto.getValue()) < 1){
            throw new PaymentException("Insufficient funds!");
        }

        Payment payment = new Payment();
        payment.setAccount(account);
        payment.setClient(client);
        payment.setDescription(dto.getDescription());
        payment.setValue(new Decimal128(dto.getValue()));
        payment.setCreateAt(LocalDate.now());
        return payment;
    }

}
