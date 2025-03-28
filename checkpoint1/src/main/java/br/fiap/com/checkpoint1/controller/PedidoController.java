package br.fiap.com.checkpoint1.controller;

import br.fiap.com.checkpoint1.model.Pedido;
import br.fiap.com.checkpoint1.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService _pedidoService;

    @GetMapping
    public List<Pedido> getPedidos(){
        return _pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id){
        return _pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido){
        return _pedidoService.createPedido(pedido);
    }

    @PutMapping("/{id}")
    public void atualizaPedido(@PathVariable Long id, @RequestBody Pedido pedido){
        _pedidoService.updatePedido(id,pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id){
        _pedidoService.deletePedido(id);
    }

}
