package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrpe.poo.banco.dados.RepositorioContaLista_8;
import br.ufrpe.poo.banco.exceptions.RepositorioException;

/**
 * 
 * @author Luis Felipe, Michel Perilo, Anderson Mateus, Thiago Henrique Gomes e Samantha Garcia
 *
 */

public class TesteRepositorioContasLista_8 {

	@Test
	public void testInserirContaRepositorioLista() throws RepositorioException {
		
		RepositorioContaLista_8 contasLista = new RepositorioContaLista_8();
		
		ContaAbstrata conta1 = new Conta("1", 0);
		
		assertTrue("Falha na inser��o ", contasLista.inserir(conta1));
		
	}
	
	@Test
	public void testRemoverContaRepositorioLista() throws RepositorioException {
		
		RepositorioContaLista_8 contasLista = new RepositorioContaLista_8();
		
		ContaAbstrata conta1 = new Conta("1", 0);
		
		contasLista.inserir(conta1);
		
		assertTrue("Falha na remo��o ", contasLista.remover("1"));
		
		
	}

}
