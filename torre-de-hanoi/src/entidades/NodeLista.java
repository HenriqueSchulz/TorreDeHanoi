package entidades;

public class NodeLista {
	
	NodeLista proximo;
	Torre torre;
	
	public NodeLista(Torre torre) {
		this.torre = torre;
	}
	
	public NodeLista (Torre torre, NodeLista proximo){
		this.torre = torre;
		this.proximo = proximo;
	}
	
	public void setProximo(NodeLista proximo) {
		this.proximo = proximo;
	}
	
	public NodeLista getProximo() {
		return this.proximo;
	}
	
	public Integer getDadoTopo() {
		return torre.getDadoTopo();
	}
	
	public Torre getTorre() {
		return this.torre;
	}
}
