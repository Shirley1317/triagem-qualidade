package com.qualidade.controller;

import com.qualidade.model.Produto;
import com.qualidade.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    public ProdutoControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarProdutos() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");

        when(produtoService.listarProdutos()).thenReturn(List.of(produto));

        ResponseEntity<List<Produto>> response = produtoController.listarProdutos();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals("Produto Teste", response.getBody().get(0).getNome());
    }

    @Test
    void salvarProduto() {
        Produto produto = new Produto();
        produto.setNome(("Produto Teste"));

        when(produtoService.salvarProduto(produto)).thenReturn(produto);

        ResponseEntity<Produto> response = produtoController.salvarProduto(produto);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Produto Teste", response.getBody().getNome());
    }

    @Test
    void atualizarProduto() {
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Produto Atualizado");

        when(produtoService.atualizarProduto(eq(1L), any(Produto.class))).thenReturn(produtoAtualizado);

        ResponseEntity<Produto> response = produtoController.atualizarProduto(1L, produtoAtualizado);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Produto Atualizado", response.getBody().getNome());
    }

    @Test
    void excluirProduto() {
        doNothing().when(produtoService).excluirProduto(1L);

        ResponseEntity<Void> response = produtoController.excluirProduto(1L);

        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
    }
}
