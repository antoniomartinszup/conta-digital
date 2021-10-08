package br.com.zup.edu.contadigital.conta;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class TransacaoRequest {
    @Positive
    private BigDecimal valor;

    public TransacaoRequest() {
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
