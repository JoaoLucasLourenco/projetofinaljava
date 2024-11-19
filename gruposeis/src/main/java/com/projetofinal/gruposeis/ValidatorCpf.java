package com.projetofinal.gruposeis;

public class ValidatorCpf {
    public static boolean validarCPF(String cpf) {
        // Verifica se o CPF está no formato correto
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }

        // Remove os caracteres especiais (pontos e traço)
        cpf = cpf.replaceAll("[.-]", "");

        // Verifica se o CPF tem todos os dígitos iguais (ex: 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula os dígitos verificadores
        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 >= 10) digito1 = 0;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 >= 10) digito2 = 0;

            // Verifica os dígitos calculados com os dígitos informados no CPF
            return digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0');
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
