package br.com.zup.edu.contadigital.exception;

public class ValorNegativoException extends RegraDeNegocioException {

    public ValorNegativoException(String field, String message) {
        super(field, message);
    }



}
