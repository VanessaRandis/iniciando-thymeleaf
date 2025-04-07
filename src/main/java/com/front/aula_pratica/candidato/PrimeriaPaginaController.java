package com.front.aula_pratica.candidato;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrimeriaPaginaController {

    @GetMapping("home") //model é uma interface
    public String primeiraPaginaHtml(Model model) { //model é atributo do springboot
        model.addAttribute("mensagemDaController", "Primeira mensagem vindo da controller");
        return "primeiraPagina";
    }

    @GetMapping("/login")
    public String loginCandidate(){
        return "candidate/login";
    }

    @PostMapping("create")
    public String cadastroCandidate(Model model, Pessoa pessoa) {
        System.out.println("Pessoa nome :" + pessoa.nome);
        System.out.println("Pessoa email :" + pessoa.email);
        System.out.println("Pessoa usuário :" + pessoa. usuario);
       // return "/candidate/login"; --> quando eu faço o cadastro desejo que seja redirecionado para o caminho
        //return "redirect:/login";// redirect para uma função já existe ,
        // mas se quiser que chame uma página template passa a opção acima
        model.addAttribute("pessoa", pessoa);
        return "candidate/info";
    }

    record Pessoa(String nome, String email, String usuario){

    }


}
