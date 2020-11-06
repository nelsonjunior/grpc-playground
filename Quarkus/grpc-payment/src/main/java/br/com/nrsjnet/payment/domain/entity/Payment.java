package br.com.nrsjnet.payment.domain.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.Decimal128;

import java.time.LocalDate;

@MongoEntity(collection = "Payment")
public class Payment extends PanacheMongoEntity {

    private String description;
    private Decimal128 value;
    private Account account;
    private Client client;
    private LocalDate createAt;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Decimal128 getValue() {
        return value;
    }

    public void setValue(Decimal128 value) {
        this.value = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
