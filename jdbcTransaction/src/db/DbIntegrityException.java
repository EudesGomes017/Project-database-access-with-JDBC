package db;

public class DbIntegrityException extends RuntimeException {

	/*
	 * /* Tratar a exceção de integridade referencial Qunado delete a tabela ex:
	 * Departament id 2 a forkey 2 da tabela saller vai peder a sua referencia
	 */
	private static final long serialVersionUID = 1L;

	public DbIntegrityException(String msg) {
		super(msg);
	}
}