package br.com.nrsjnet.payment.domain.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.Decimal128;

@MongoEntity(collection = "Account")
public class Account extends PanacheMongoEntity {

    private String uuid;
    private String accountIdent;
    private String accountDescription;
    private Decimal128 actualBalance;

    public String getAccountIdent() {
        return accountIdent;
    }

    public void setAccountIdent(String accountIdent) {
        this.accountIdent = accountIdent;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public Decimal128 getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(Decimal128 actualBalance) {
        this.actualBalance = actualBalance;
    }
}
