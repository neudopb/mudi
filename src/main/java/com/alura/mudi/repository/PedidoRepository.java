package com.alura.mudi.repository;

import com.alura.mudi.enums.StatusEnum;
import com.alura.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusEnum status);

}
