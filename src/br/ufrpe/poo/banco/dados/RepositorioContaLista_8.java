package br.ufrpe.poo.banco.dados;

import java.util.ArrayList;

import br.ufrpe.poo.banco.exceptions.RepositorioException;
import br.ufrpe.poo.banco.iterator.IteratorContaAbstrata;
import br.ufrpe.poo.banco.negocio.ContaAbstrata;

/**
 * 
 * @author Luis Felipe, Michel Perilo, Anderson Mateus, Thiago Henrique Gomes e Samantha Garcia
 *
 */

public class RepositorioContaLista_8 implements IRepositorioContas{
	
	private ArrayList<ContaAbstrata> contas = new ArrayList<ContaAbstrata>();

	@Override
	public boolean inserir(ContaAbstrata conta) throws RepositorioException {
		// TODO Auto-generated method stub
		return this.contas.add(conta);
	}

	@Override
	public boolean remover(String numero) throws RepositorioException {
		// TODO Auto-generated method stub
		ContaAbstrata c = this.procurar(numero);
		return this.contas.remove(c);
	}
	
	
	
	@Override
	public ContaAbstrata procurar(String numero) {
		// TODO Auto-generated method stub
		for (ContaAbstrata contaAbstrata : this.contas) {
			if(contaAbstrata.getNumero().equals(numero)){
				return contaAbstrata;
			}
		}
		return null;
	}


	@Override
	public boolean atualizar(ContaAbstrata conta) throws RepositorioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(String numero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IteratorContaAbstrata getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
