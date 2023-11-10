package club;

public class Autorizados {
	
	private String autorizados[][] ;
	
	public Autorizados() {
	}
	
	public Autorizados(int size) {
		super();
		this.autorizados = new String[size][2];
	}

	public String getNombre(int i) {
		return autorizados[i][1];
	}
	
    public String[][] getAutorizados() {
		return this.autorizados;
	}

	public void setAutorizados(int i,String cedula, String nombre) {
		i = i + this.count();
		this.autorizados[i][0] = cedula;
		this.autorizados[i][1] = nombre;
	}
	
	public int countAutorizados(String cedula) {
		
		int contador = 0;
		for (int i=0; i<this.autorizados.length;i++) {
			if (this.autorizados[i][0] != null && this.autorizados[i][0].equals(cedula)) {
				contador = contador+1;
			}
		}
		return contador;
	}
	
	
	public int count() {
		int count = 0;
		for (int i=0; i<autorizados.length;i++) {
			if(this.autorizados[i][0] != null) {
				count = count + 1;
			}
		}
		return count;
	}
	
	
	
	
	
	
	

}
