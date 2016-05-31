package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dados.CreditoDAO;
import Dados.PagamentoDAO;
import Entidades.Boleto;
import Entidades.Credito;
import Entidades.Fatura;
import Entidades.Pagamento;
import Entidades.Util;

public class TesteBoletos {

	@Test
	public void test() {
		
		Fatura faturas = new Fatura();
		
		List<Boleto> boleto = new ArrayList<Boleto>() ;
	    Boleto b1 = new Boleto();
	    Boleto b2 = new Boleto();
	    Boleto b3 = new Boleto();
		
	    b1.setValor(500);
	    b2.setValor(400);
	    b3.setValor(600);
	    
		
	    boleto. add(b1);
	    boleto. add(b2);
	    boleto. add(b3);
	    
		
		faturas.setValor(1500.0);
		
		Util.processadorBoleto(boleto, faturas);
		
		assertEquals(faturas.getSituacao(),"PAGA");
		
		Pagamento pag1;
		PagamentoDAO pagDAO=new PagamentoDAO();
		pag1 = pagDAO.pesquisarPagamento(b1);
		assertNotNull(pag1);
		
		Pagamento pag2;
		pag2 = pagDAO.pesquisarPagamento(b2);
		assertNotNull(pag2);
		

		Pagamento pag3;
		pag3 = pagDAO.pesquisarPagamento(b3);
		assertNotNull(pag3);
	}


	
	@Test
	public void teste2() {

		Fatura faturas = new Fatura();
		
		List<Boleto> boleto = new ArrayList<Boleto>() ;
	    Boleto b1 = new Boleto();
	    Boleto b2 = new Boleto();
	    Boleto b3 = new Boleto();
		
	    b1.setValor(1000);
	    b2.setValor(500);
	    b3.setValor(250);
	    
		
	    boleto. add(b1);
	    boleto. add(b2);
	    boleto. add(b3);
	    
	    faturas.setValor(1500.0);
		
		Util.processadorBoleto(boleto, faturas);
		
		assertEquals(faturas.getSituacao(),"PAGA");
		
		Pagamento pag1;
		PagamentoDAO pagDAO=new PagamentoDAO();
		pag1 = pagDAO.pesquisarPagamento(b1);
		assertNotNull(pag1);
		
		Pagamento pag2;
		pag2 = pagDAO.pesquisarPagamento(b2);
		assertNotNull(pag2);
		

		Pagamento pag3;
		pag3 = pagDAO.pesquisarPagamento(b3);
		assertNotNull(pag3);
		
		Credito credito;
		CreditoDAO credDAO = new CreditoDAO();
		credito = credDAO.pesquisarCredito(faturas.getNomeCliente(),250.0);
	    assertNotNull(credito);
		}
	}
