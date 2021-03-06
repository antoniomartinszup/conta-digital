package br.com.zup.edu.contadigital.conta.transacao;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {

    @Positive
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
