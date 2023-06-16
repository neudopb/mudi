package com.alura.mudi.controller;

import com.alura.mudi.dto.PedidoNewDTO;
import com.alura.mudi.model.Pedido;
import com.alura.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String form(PedidoNewDTO pedidoNew) {
        return "pedido/form";
    }

    @PostMapping
    public String save(@Valid PedidoNewDTO pedidoNew, BindingResult result) {
        if(result.hasErrors()) {
            return "pedido/form";
        }
        Pedido pedido = new Pedido(pedidoNew);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
