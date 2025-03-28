package br.fiap.com.checkpoint1.repository;

import br.fiap.com.checkpoint1.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
