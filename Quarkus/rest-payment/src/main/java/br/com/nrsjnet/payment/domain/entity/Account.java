package br.com.nrsjnet.payment.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Account extends PanacheEntity {

    private UUID uuid = UUID.randomUUID();
    private String accountIdent;
    private String accountDescription;
    private BigDecimal actualBalance;

    public String getAccountIdent() {
        return accountIdent;
    }

    public void setAccountIdent(String accountIdent) {
        this.accountIdent = accountIdent;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    public BigDecimal getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(BigDecimal actualBalance) {
        this.actualBalance = actualBalance;
    }
}
