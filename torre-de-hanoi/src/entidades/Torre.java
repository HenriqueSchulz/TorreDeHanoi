package entidades;

public class Torre {
	
	private NodeTorre topo;
	private Integer tamanho;
	
	public Torre(){}
	
	public Torre(Integer tamanho) {
		
		this.tamanho = tamanho;
		this.topo = null;
		
	}
	
	public boolean vazia() {
		if(topo == null) {
			return true;
		}
		return false;
	}
	
	public boolean cheia() {
		
		int elementos = 0;
		NodeTorre atual = topo;
		
		while(atual != null) {
			elementos++;
			atual = atual.getProximo();
		}
		
		if(elementos == tamanho) {
			return true;
		}
		return false;	
		
	}
	
	public void inserir(int dado) {
		if(!cheia()) {
			topo = new NodeTorre(dado, topo);
		}
	}
	
	public void remover() {
		if(!vazia()) {
			topo = topo.getProximo();
		}
	}
	
	public Integer getTamanho() {
		return this.tamanho;
	}
	
	public Integer getDadoTopo() {
		if(this.topo == null) {
			return -1;
		}
		return topo.getDado();
	}
	
	public NodeTorre getTopo() {
		return this.topo;
	}
	
}
