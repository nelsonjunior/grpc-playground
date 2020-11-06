package br.com.nrsjnet.payment.presentation;

import br.com.nrsjnet.grpc.Payment;
import br.com.nrsjnet.grpc.PaymentRequest;
import br.com.nrsjnet.grpc.PaymentServiceGrpc;
import br.com.nrsjnet.grpc.TicketPay;
import br.com.nrsjnet.payment.domain.dto.PaymentRequestDTO;
import br.com.nrsjnet.payment.domain.dto.TicketPaymentDTO;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.ejb.PostActivate;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    @GrpcService("payment-grpc-service")
    PaymentServiceGrpc.PaymentServiceBlockingStub client;

    @POST
    public Response save(PaymentRequestDTO dto){
        TicketPay ticketPay = client.pay(createPaymentRequest(dto));
        TicketPaymentDTO ticketPayment = createTicketPayment(ticketPay);
        return Response.ok(ticketPayment).build();
    }

    private TicketPaymentDTO createTicketPayment(TicketPay ticketPay) {
        if(!ticketPay.getSuccess()){
            throw new NotAcceptableException(ticketPay.getErrorMessage());
        }
        return new TicketPaymentDTO(ticketPay.getUuidPayment());
    }

    private PaymentRequest createPaymentRequest(PaymentRequestDTO dto) {
        return PaymentRequest.newBuilder()
                .setDescription(dto.getDescription())
                .setValue(dto.getValue().doubleValue())
                .setUuidClient(dto.getUuidClient())
                .setUuidAccountPayment(dto.getUuidAccount())
                .build();
    }


}
