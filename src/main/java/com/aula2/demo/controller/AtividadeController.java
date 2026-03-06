package com.aula2.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RestController // Avisa ao Spring que esta classe responde a requisições na web
public class AtividadeController {

    /* --- ATIVIDADE 1 --- */

    // 1. Saudação personalizada [cite: 5]
    @GetMapping("/saudacao/{nome}")
    public String saudacao(@PathVariable String nome) {
        return "Olá, " + nome + "! Bem-vindo(a) ao Spring Boot!";
    }

    // 2. Soma de dois números [cite: 10]
    @GetMapping("/soma/{n1}/{n2}")
    public String somar(@PathVariable double n1, @PathVariable double n2) {
        return "O resultado da soma é: " + (n1 + n2);
    }

    // 3. Informações simplificadas do sistema [cite: 14]
    @GetMapping("/info")
    public String infoSimples() {
        return "Aplicação: " + "Projeto Aula 2" +
                " | Java: " + System.getProperty("java.version") +
                " | Hora: " + LocalDateTime.now();
    }

    /* --- ATIVIDADE 2 (API REST ESTUDANTES) --- */

    // Endpoint 1: Info detalhada [cite: 39]
    @GetMapping("/api/sistema/info")
    public String apiInfo() {
        return "Sistema: Cadastro de Estudantes | Versão: 1.0 | Status: operacional";
    }

    // Endpoint 2: Listar Cursos [cite: 43]
    @GetMapping("/api/cursos")
    public List<String> listarCursos() {
        return Arrays.asList("ADS", "Engenharia", "Direito", "Medicina", "Psicologia");
    }

    // Endpoint 3: Buscar Curso por ID [cite: 47]
    @GetMapping("/api/cursos/{id}")
    public String buscarCurso(@PathVariable int id) {
        List<String> cursos = Arrays.asList("", "ADS", "Engenharia", "Direito", "Medicina", "Psicologia");
        if (id >= 1 && id < cursos.size()) {
            return cursos.get(id);
        }
        return "Curso não encontrado";
    }

    // Endpoint 4: Informações de Estudante [cite: 51]
    @GetMapping("/api/estudantes/{matricula}")
    public String buscarEstudante(@PathVariable String matricula) {
        if (matricula.equals("2024001")) {
            return "Matrícula: 2024001 | Nome: Aluno Teste | Curso: ADS | Semestre: 1º";
        }
        return "Estudante não encontrado (Tente a matrícula 2024001)";
    }

    /* --- ENDPOINT CRIATIVO --- */
    // Conversor de Temperatura (Celsius para Fahrenheit) [cite: 23]
    @GetMapping("/converter/{celsius}")
    public String converter(@PathVariable double celsius) {
        double f = (celsius * 9/5) + 32;
        return celsius + "°C equivale a " + f + "°F";
    }
}