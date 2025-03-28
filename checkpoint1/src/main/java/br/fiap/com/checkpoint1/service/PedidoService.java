package br.fiap.com.checkpoint1.service;

import br.fiap.com.checkpoint1.model.Pedido;
import br.fiap.com.checkpoint1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository _pedidoRepository;

    public List<Pedido> getAllPedidos(){
        return _pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id){
        return  _pedidoRepository.getById(id);
    }

    public Pedido createPedido(Pedido pedido){
        Pedido pedidoNovo = new Pedido(pedido.getClienteNome(), pedido.getValorTotal());
        _pedidoRepository.save(pedidoNovo);
        return pedidoNovo;
    }

    public void updatePedido(Long id,Pedido pedidoNovo){
        Pedido pedidoantigo = _pedidoRepository.getById(id);
        pedidoantigo.setClienteNome(pedidoNovo.getClienteNome());
        pedidoantigo.setValorTotal(pedidoNovo.getValorTotal());
        _pedidoRepository.save(pedidoantigo);
    }

    public void deletePedido(Long id){
        _pedidoRepository.deleteById(id);
    }



}
