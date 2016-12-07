/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.natalialopessilva.calcular;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.util.List;

/**
 * Classe responsável por coletar uma expressão fornecida pelo usuário, e
 * forneceder o resultado gerado pelo Parser.
 */
public final class Calcular {

    /**
     * Construtor da classe Calcular que impede que a mesma seja instanciada ou
     * acessada.
     */
    private Calcular() {
    }

    /**
     * Lê uma expressão matemática e verifica sua validade, exibindo.
     *
     * @param args como argumentos passados a classe principal.
     *
     */
    public static void main(final String[] args) {

        if (args.length == 0) {
            System.out.println("Expressão está vazia");
            System.exit(1);
        }

        try {
            System.out.println(exprPara(args[0]).valor());
            System.exit(0);
        } catch (IllegalArgumentException ex) {
            System.err.println("Expressão inválida");
            System.exit(1);
        }
    }

    /**
     * Lê uma expressão matemática.
     *
     * @param expressao como argumentos recebido.
     *
     * @return expressao recebida.
     */
    public static Expressao exprPara(final String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
    }
}
