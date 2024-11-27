package com.qualidade.service;

import com.qualidade.model.Produto;
import com.qualidade.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    public ProdutoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarProdutos() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");

        when(produtoRepository.findAll()).thenReturn(List.of(produto));

        List<Produto> produtos = produtoService.listarProdutos();

        assertNotNull(produtos);
        assertEquals(1, produtos.size());
        assertEquals("Produto Teste", produtos.get(0).getNome());
    }

    @Test
    void atualizarProduto() {
        Produto produto = new Produto();
        produto.setNome("Produto Original");

        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Produto Atualizado");

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoAtualizado);

        Produto atualizado = produtoService.atualizarProduto(1L, produtoAtualizado);

        assertNotNull(atualizado);
        assertEquals("Produto Atualizado", atualizado.getNome());
    }

    @Test
    void atualizarProduto_naoEncontrado() {
        Produto produtoAtualizado = new Produto();
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> produtoService.atualizarProduto(1L, produtoAtualizado));
        assertEquals("Produto não encontrado", exception.getMessage());
    }

    void excluirProduto() {
        doNothing().when(produtoRepository).deleteById(1L);

        produtoService.excluirProduto(1L);

        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
