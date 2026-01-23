package br.com.alura.adopet.api.service;

public class ValidacaoExpection extends RuntimeException {
    public ValidacaoExpection(String message) {
        super(message);
    }
}
