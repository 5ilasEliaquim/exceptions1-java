package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  throws DomainExceptions{
		// isso é chamado de programação defensiva, pois estamos tratando antes de gerar o erro
		
		if(!checkOut.after(checkIn)) {
			throw new DomainExceptions("Erro na reserva: A data de saida deve ser depois da data de entrada");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// para calcularmos a duração sera em millisegundo por isso retornaremos o long 
		
		// get.time pega o tempo em millisegundos então fazemos a subtração e temos o resultado
		
		long diff = checkOut.getTime() - checkIn.getTime();
		
		// agora vamos converter os millisegundos em dias 
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
				
	}
	
	
	// deixaremos o metodo vazio, e agora vamos lançar uma exceção  que é a Illegal, que usamos quando os argumentos
	//são invalidos
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions {
		
		Date now = new Date();
		if(checkIn.before(now)|| checkOut.after(now)) {
			throw new DomainExceptions("Erro na reserva: A data deve ser futura ");
		} 
		if(!checkOut.after(checkIn)) {
			throw new DomainExceptions("Erro na reserva: A data de saida deve ser depois da data de entrada");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		// e ai no bloco principal fazemos um catch capturando esse tipo de excecao
		
	}
	
	@Override
	
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", Check-in"
				+ sdf.format(getCheckIn())
				+ ", check-out: "
				+sdf.format(getCheckOut())
				+", "
				+ duration()
				+ " nights";
	}
	
}
