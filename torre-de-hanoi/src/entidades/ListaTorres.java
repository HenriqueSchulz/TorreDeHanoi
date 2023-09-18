package entidades;

public class ListaTorres {
	
	private NodeLista primeiro;
	private NodeLista ultimo;
	
	public ListaTorres(){
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public ListaTorres(NodeLista primeiro){
		this.primeiro = primeiro;
		this.ultimo = primeiro;
	}
	
	public void inserir(NodeLista proximo) {
		if(primeiro == null) {
			this.primeiro = proximo;
			this.ultimo = proximo;
		} else {
			ultimo.setProximo(proximo);
			ultimo = ultimo.getProximo();
		}
	}	
	
	public NodeLista getPrimeiro() {
		return this.primeiro;
	}
	
	public NodeLista getUltimo() {
		return this.ultimo;
	}
}
