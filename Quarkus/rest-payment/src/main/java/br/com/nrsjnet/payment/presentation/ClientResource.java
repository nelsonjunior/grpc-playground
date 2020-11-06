package br.com.nrsjnet.payment.presentation;

import br.com.nrsjnet.payment.domain.entity.Account;
import br.com.nrsjnet.payment.domain.entity.Client;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface ClientResource extends PanacheEntityResource<Client, Long> {

}
