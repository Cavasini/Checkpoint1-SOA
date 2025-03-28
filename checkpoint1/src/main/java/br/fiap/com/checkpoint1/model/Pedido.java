package br.fiap.com.checkpoint1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {

    public Pedido(String clientNome, double valorTotal){
        validarPedido(clientNome, valorTotal);
        this.clienteNome = clientNome;
        this.dataPedido = LocalDate.now();
        this.valorTotal = valorTotal;
    }

    public Pedido(Long id, String clienteNome, LocalDate dataPedido, double valorTotal) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
    }

    public Pedido(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String clienteNome;
    private LocalDate dataPedido;
    private double valorTotal;

    private void validarPedido(String clienteNome, Double valorTotal) {
        if (clienteNome == null || clienteNome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório e não pode ser vazio.");
        }

        if (valorTotal == null) {
            throw new IllegalArgumentException("O valor total do pedido não pode ser nulo.");
        }
        if (valorTotal < 0) {
            throw new IllegalArgumentException("O valor total do pedido não pode ser negativo.");
        }
    }


    public Long getId() {
        return id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
