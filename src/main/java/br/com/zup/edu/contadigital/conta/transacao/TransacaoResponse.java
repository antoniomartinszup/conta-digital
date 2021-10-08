package br.com.zup.edu.contadigital.conta.transacao;

import java.math.BigDecimal;

public class TransacaoResponse {

    private Long id;

    private BigDecimal saldo;

    public TransacaoResponse(Long id, BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
