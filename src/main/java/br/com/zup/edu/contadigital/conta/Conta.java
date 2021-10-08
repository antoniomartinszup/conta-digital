package br.com.zup.edu.contadigital.conta;

import br.com.zup.edu.contadigital.cliente.Cliente;
import br.com.zup.edu.contadigital.conta.transacao.TransacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    @OneToOne
    private Cliente cliente;
    private BigDecimal saldo = BigDecimal.ZERO;

    public void credita(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void debita(BigDecimal valor) {
        if (valor.compareTo(this.saldo) >= 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Saldo Insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public TransacaoResponse toDto() {
        return new TransacaoResponse(id, saldo);
    }
}
