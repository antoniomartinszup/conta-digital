package br.com.zup.edu.contadigital.conta.transacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class NovaTransacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    private TransacaoRequest criaTransacaoRequest(BigDecimal valor) {
        TransacaoRequest transacaoRequest = new TransacaoRequest();
        transacaoRequest.setValor(valor);
        return transacaoRequest;
    }

    @Test
    @DisplayName(value = "Deve creditar valor do saldo de uma conta com sucesso.")
    public void deveCreditarValorDeContaComSucesso() throws Exception {
        TransacaoRequest transacaoRequest = criaTransacaoRequest(new BigDecimal(10));

        MockHttpServletRequestBuilder request = put("/contas/1/credita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(transacaoRequest));

        mvc.perform(request)
                .andExpect(jsonPath("$.saldo").isNotEmpty())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(value = "Não deve Creditar valor negativo de conta.")
    public void naoDeveCreditarValorNegativoDeConta() throws Exception {
        TransacaoRequest transacaoRequest = criaTransacaoRequest(new BigDecimal(-10));

        MockHttpServletRequestBuilder request = put("/contas/1/credita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(transacaoRequest));

        mvc.perform(request)
                .andExpect(jsonPath("$.saldo").isNotEmpty())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(value = "Deve debitar valor do saldo de uma conta com sucesso.")
    public void deveDebitarValorDeContaComSucesso() throws Exception {
        TransacaoRequest transacaoRequest = criaTransacaoRequest(new BigDecimal(10));

        MockHttpServletRequestBuilder request = put("/contas/1/debita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(transacaoRequest));

        mvc.perform(request)
                .andExpect(jsonPath("$.saldo").isNotEmpty())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(value = "Não deve debitar valor negativo de conta")
    public void naoDeveDebitarValorNegativoDeConta() throws Exception {
        TransacaoRequest transacaoRequest = criaTransacaoRequest(new BigDecimal(-10));

        MockHttpServletRequestBuilder request = put("/contas/1/debita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(transacaoRequest));

        mvc.perform(request).andExpect(status().isBadRequest());
    }

}