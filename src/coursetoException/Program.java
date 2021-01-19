package coursetoException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {


		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data inicial de reserva dd/MM/yyyy: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data final de reserva dd/MM/yyyy: ");
		Date checkOut = sdf.parse(sc.next());
		
		// fazendo validação se data é posterior a outra
		
		// se checkout não for depois que checkin deve dar erro.
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de saida deve ser depois da data de entrada");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Informe a data para atualizar a reserva");
			System.out.print("Data inicial de reserva dd/MM/yyyy: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data final de reserva dd/MM/yyyy: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now)|| checkOut.after(now)) {
				System.out.println("Erro na reserva: A data deve ser futura ");
			} else if(!checkOut.after(checkIn)) {
				// se checkout não for depois que checkin deve dar erro.
					System.out.println("Erro na reserva: A data de saida deve ser depois da data de entrada");
			}
			else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		}
		sc.close();
	}

}
