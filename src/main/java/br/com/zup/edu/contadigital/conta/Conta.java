package br.com.zup.edu.contadigital.conta;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Long idCliente;
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
}
