package entidades;

public class NodeTorre {
	
	NodeTorre proximo;
	Integer dado;
	
	public NodeTorre(int dado) {
		this.dado = dado;
	}
	
	public NodeTorre (int dado, NodeTorre proximo){
		this.dado = dado;
		this.proximo = proximo;
	}
	
	public void setProximo(NodeTorre proximo) {
		this.proximo = proximo;
	}
	
	public NodeTorre getProximo() {
		return this.proximo;
	}
	
	public Integer getDado() {
		return this.dado;
	}
	
}
