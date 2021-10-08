package br.com.zup.edu.contadigital.conta.transacao;

import br.com.zup.edu.contadigital.conta.Conta;
import br.com.zup.edu.contadigital.conta.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/contas")
public class NovaTransacaoController {

    @Autowired
    private ContaRepository contaRepository;

    @Transactional
    @PutMapping("/{id}/credita")
    public TransacaoResponse credita(@PathVariable Long id, @Valid @RequestBody TransacaoRequest request) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conta informada não existe"));

        conta.credita(request.getValor());

        return conta.toDto();
    }

    @Transactional
    @PutMapping("/{id}/debita")
    public TransacaoResponse debita(@PathVariable Long id, @Valid @RequestBody TransacaoRequest request) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A conta informada não existe"));

        conta.debita(request.getValor());

        return conta.toDto();
    }
}
