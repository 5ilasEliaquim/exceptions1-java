package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
		// para calcularmos a dura��o sera em millisegundo por isso retornaremos o long 
		
		// get.time pega o tempo em millisegundos ent�o fazemos a subtra��o e temos o resultado
		
		long diff = checkOut.getTime() - checkIn.getTime();
		
		// agora vamos converter os millisegundos em dias 
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
				
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
