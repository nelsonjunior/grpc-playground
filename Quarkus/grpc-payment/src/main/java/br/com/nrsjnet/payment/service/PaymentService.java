package br.com.nrsjnet.payment.service;

import br.com.nrsjnet.grpc.PaymentRequest;
import br.com.nrsjnet.grpc.PaymentServiceGrpc;
import br.com.nrsjnet.grpc.TicketPay;
import br.com.nrsjnet.payment.converter.PaymentConverter;
import br.com.nrsjnet.payment.domain.dto.PaymentRequestDTO;
import br.com.nrsjnet.payment.domain.entity.Account;
import br.com.nrsjnet.payment.domain.entity.Payment;
import br.com.nrsjnet.payment.exception.PaymentException;
import io.grpc.stub.StreamObserver;
import org.bson.types.Decimal128;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.UUID;

@Singleton
public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase{

    @Inject
    ValidatePaymentService validatePaymentService;

    @Override
    public void pay(PaymentRequest request, StreamObserver<TicketPay> responseObserver) {
        PaymentRequestDTO dto = PaymentConverter.from(request);

        TicketPay.Builder ticket = TicketPay.newBuilder();
        ticket.setUuidPayment(UUID.randomUUID().toString());


        try {
            Payment paymentValid = validatePaymentService.validate(dto);

            updateBalance(paymentValid);

            paymentValid.persist();

            ticket.setSuccess(true);

        } catch (PaymentException e) {
            ticket.setSuccess(false);
            ticket.setErrorMessage(e.getMessage());
        }

        responseObserver.onNext(ticket.build());
        responseObserver.onCompleted();
    }

    private void updateBalance(Payment payment) {
        Account account = payment.getAccount();

        BigDecimal newBalance = account.getActualBalance().bigDecimalValue().subtract(payment.getValue().bigDecimalValue());

        account.setActualBalance(new Decimal128(newBalance));

        account.persistOrUpdate();
    }
}
