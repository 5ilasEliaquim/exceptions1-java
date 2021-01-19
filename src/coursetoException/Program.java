package coursetoException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		//vamos tratar as excecoes e por isso apagamos o throw

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			
			System.out.print("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.print("Data inicial de reserva dd/MM/yyyy: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data final de reserva dd/MM/yyyy: ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Informe a data para atualizar a reserva");
			System.out.print("Data inicial de reserva dd/MM/yyyy: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data final de reserva dd/MM/yyyy: ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
	catch(ParseException e){
		System.out.println("Formato de data invalido");
	}
	catch(DomainExceptions e){
		System.out.println("Erro na reserva" + e.getMessage()); 
		// get message pega a mensagem do metodo que tem o illegal
	}
	catch (RuntimeException e){
		System.out.println("Erro inesperado");
	}
	
		sc.close();
	}

}
