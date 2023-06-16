package com.alura.mudi.controller;

import com.alura.mudi.enums.StatusEnum;
import com.alura.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ModelAndView home() {
        var pedidos = pedidoRepository.findAll();

        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);

        return mv;
    }

    @GetMapping("/{status}")
    public ModelAndView byStatus(@PathVariable("status") String status) {
        var pedidos = pedidoRepository.findByStatus(StatusEnum.valueOf(status.toUpperCase()));

        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        mv.addObject("status", status);

        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
