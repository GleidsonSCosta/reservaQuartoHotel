package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date now = new Date();
		
		System.out.print("Digite o número do quarto:");
		Integer numQuarto = sc.nextInt();
		
		System.out.print("Digite a data de check-in (dd/MM/yyy): ");
		Date checkin = sdf.parse(sc.next());
		
		System.out.print("Didgite a data de check-out (dd/MM/yyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//veficica se data check-out é superior a data de check-in
		if(!checkout.after(checkin)) {
			System.out.println("A data de check-out deve ser após a data de check-in");
		}else if(checkin.before(now) || checkout.before(now)) {
			System.out.println("As datas devem ser futuras.");
		}
		else {
			Reserva reserva = new Reserva(numQuarto, checkin, checkout);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Atualizar a reserva.");
			
			System.out.print("Digite a data de check-in (dd/MM/yyy): ");
			checkin = sdf.parse(sc.next());
			
			System.out.print("Didgite a data de check-out (dd/MM/yyy): ");
			checkout = sdf.parse(sc.next());
			
			String erro = reserva.atualizaDatas(checkin, checkout);
			
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}else {	
				System.out.println("Reserva: " + reserva);
			}
						
			
		}
		
		sc.close();
	}

}
