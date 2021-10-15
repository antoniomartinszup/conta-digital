package br.com.zup.edu.contadigital.conta.transacao;

import br.com.zup.edu.contadigital.conta.Conta;
import br.com.zup.edu.contadigital.conta.ContaRepository;
import br.com.zup.edu.contadigital.exception.ValorNegativoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
public class NovaTransacaoController {

    private Logger log = LoggerFactory.getLogger(NovaTransacaoController.class);

    @Autowired
    private ContaRepository contaRepository;

    @Transactional
    @PutMapping("/{id}/credita")
    public TransacaoResponse credita(@PathVariable Long id, @Valid @RequestBody TransacaoRequest request) throws ValorNegativoException {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conta informada não existe"));

        BigDecimal valorRecebio = request.getValor();

        if(valorRecebio.compareTo(BigDecimal.ZERO) < 0){
            throw new ValorNegativoException("Valor do Credito","Impossivel creditar valor negativo");
        };


        conta.credita(request.getValor());

        log.info("Creditou " + request.getValor() + " na conta " + id);
        return conta.toDto();
    }

    @Transactional
    @PutMapping("/{id}/debita")
    public TransacaoResponse debita(@PathVariable Long id, @Valid @RequestBody TransacaoRequest request) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conta informada não existe"));

        conta.debita(request.getValor());

        log.info("Debitou " + request.getValor() + " na conta " + id);
        return conta.toDto();
    }
}
