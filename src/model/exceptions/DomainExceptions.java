package model.exceptions;

public class DomainExceptions extends Exception {

	// valor padr�o de serializable
	private static final long serialVersionUID = 1L;

	// quando uma classe � exce��o colocamos o nome exception nela
	// essa � nossa classe personalizada de exce��o
	// o nome Domain � porqu� ele tratara o erro que e lan�ada na entidade de  dominio
	
	
	// assim instanciamos nosso construtor passando uma mensagem
	public DomainExceptions(String msg) {
		super(msg);
	}
}
