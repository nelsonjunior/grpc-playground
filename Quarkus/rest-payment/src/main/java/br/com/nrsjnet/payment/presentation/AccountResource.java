package br.com.nrsjnet.payment.presentation;

import br.com.nrsjnet.payment.domain.entity.Account;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface AccountResource extends PanacheEntityResource<Account, Long> {

}
