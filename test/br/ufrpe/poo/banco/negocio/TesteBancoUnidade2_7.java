package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.ufrpe.poo.banco.dados.IRepositorioContas;
import br.ufrpe.poo.banco.exceptions.ContaJaCadastradaException;
import br.ufrpe.poo.banco.exceptions.ContaNaoEncontradaException;
import br.ufrpe.poo.banco.exceptions.InicializacaoSistemaException;
import br.ufrpe.poo.banco.exceptions.RenderBonusContaEspecialException;
import br.ufrpe.poo.banco.exceptions.RepositorioException;
import br.ufrpe.poo.banco.exceptions.SaldoInsuficienteException;
import br.ufrpe.poo.banco.exceptions.ValorInvalidoException;

/**
 * 
 * @author Luis Felipe, Michel Perilo, Anderson Mateus, Thiago Henrique Gomes e Samantha Garcia
 *
 */

@RunWith(Parameterized.class)
public class TesteBancoUnidade2_7 {

	private double saldoOrigemAntes;
	private double saldoDestinoAntes;
	private double valorTransferir;
	private double saldoOrigemDepois;
	private double saldoDestinoDepois;

	public TesteBancoUnidade2_7(double oa, double da, double v, double od,
			double dd) {
		this.saldoOrigemAntes = oa;
		this.saldoDestinoAntes = da;
		this.valorTransferir = v;
		this.saldoOrigemDepois = od;
		this.saldoDestinoDepois = dd;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {{ 100, 100, 200, 100, 100 },  { 100, 100, 50, 50, 150 },
				{ 100, 100, 100, 0, 200 } };
		return Arrays.asList(data);
	}
	
	public static Banco getBancoMock() {
		IRepositorioContas contasMock = mock(IRepositorioContas.class);
		Banco bancoMock = new Banco(null, contasMock);
		return bancoMock;
	}

	@Test
	public void testeTransferenciaEntreContasCorrente()  throws InicializacaoSistemaException, RepositorioException,
	ContaJaCadastradaException, SaldoInsuficienteException, ValorInvalidoException {
		
		Banco banco = getBancoMock();
		
		Conta origem = new Conta("1", this.saldoOrigemAntes);
		Conta destino = new Conta("2", this.saldoDestinoAntes);
		
		when(banco.contas.inserir(origem)).thenReturn(true);
		when(banco.contas.procurar("1")).thenReturn(origem);
		when(banco.contas.existe("2")).thenReturn(false);
		
		if(banco.contas.procurar("2") == null){
			banco.transferir(origem, destino, this.valorTransferir);
		}
		
		assertEquals(this.saldoOrigemAntes, origem.getSaldo(),0);
		assertEquals(this.saldoDestinoAntes, destino.getSaldo(),0);
		
	}
	
	
	

}
