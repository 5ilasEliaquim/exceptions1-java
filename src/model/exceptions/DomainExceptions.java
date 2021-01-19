package model.exceptions;

public class DomainExceptions extends Exception {

	// valor padrão de serializable
	private static final long serialVersionUID = 1L;

	// quando uma classe é exceção colocamos o nome exception nela
	// essa é nossa classe personalizada de exceção
	// o nome Domain é porquê ele tratara o erro que e lançada na entidade de  dominio
	
	
	// assim instanciamos nosso construtor passando uma mensagem
	public DomainExceptions(String msg) {
		super(msg);
	}
}
