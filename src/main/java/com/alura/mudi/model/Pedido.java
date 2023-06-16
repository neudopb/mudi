package com.alura.mudi.model;

import com.alura.mudi.dto.PedidoNewDTO;
import com.alura.mudi.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImg;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public Pedido(PedidoNewDTO pedidoNew) {
        this.nome = pedidoNew.nomeProduto();
        this.urlProduto = pedidoNew.urlProduto();
        this.urlImg = pedidoNew.urlImg();
        this.descricao = pedidoNew.descricao();
        this.status = StatusEnum.AGUARDANDO;
    }
}
