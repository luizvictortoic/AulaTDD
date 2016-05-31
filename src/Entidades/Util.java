package Entidades;

import java.util.List;

public class Util {

	
	public static void processadorBoleto(List<Boleto> boleto, Fatura fatura) {

		double soma = 0;
		
		for(Boleto b : boleto){
			soma += b.getValor();
		}
		if(soma >= fatura.getValor()){
			fatura.setSituacao("PAGA");
		}
	}

}
