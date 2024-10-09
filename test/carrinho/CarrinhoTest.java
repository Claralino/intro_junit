package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste dco Carrinho")

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        produto1 = new Produto("Produto 1", 10.0);
        produto2 = new Produto("Produto 2", 20.0);
    }

    @Test
    @DisplayName("Testa adicionar produto ao carrinho")
    public void testAddItem() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa remover um produto do carrinho")
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Testa remover um produto não existente")
    public void testRemoveItemNaoEncontrado() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto1);
        });
    }

    @Test
    @DisplayName("Testa valor total do carrinho")
    public void testGetValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(30.0, carrinho.getValorTotal(), 0.01);
    }
}

