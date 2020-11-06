package br.com.nrsjnet.payment;

import br.com.nrsjnet.payment.domain.entity.Account;
import br.com.nrsjnet.payment.domain.entity.Client;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.bson.types.Decimal128;

import java.time.LocalDate;

@QuarkusMain
public class MainApplication implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Payment GRPC Service");
        System.out.println("--------- Insert init data --------");

        Account.deleteAll();

        Account account = new Account();
        account.setUuid("ffb71bf2-35d9-41f3-b5dc-5de53c803667");
        account.setAccountIdent("1244-84");
        account.setAccountDescription("Conta Corrent");
        account.setActualBalance(Decimal128.parse("35000.00"));
        account.persist();

        Client.deleteAll();
        Client client = new Client();
        client.setBirth(LocalDate.of(1986, 2, 2));
        client.setUuid("d80bac91-c86b-4af6-a008-7439e3cf7f12");
        client.setName("Nelson");
        client.persist();

        Quarkus.waitForExit();
        return 0;
    }
}