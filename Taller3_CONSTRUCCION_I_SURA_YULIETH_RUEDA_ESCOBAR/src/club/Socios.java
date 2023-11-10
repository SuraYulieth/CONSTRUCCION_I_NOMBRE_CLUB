package club;

public class Socios {
	String Datos;
	String Cedula;
	String Nombre;
	String fondosDisponibles;
	String tipoSuscripcion;
	String facSin_pagar;
	String personasAutorizadas;
	String[][] matrizMembers = new String[35][7];
	
	public Socios () {
	}
	
	public Socios(String datos, String cedula, String nombre, String fondosDisponibles, String tipoSuscripcion,
			String facSin_pagar, String personasAutorizadas) {
		this.Datos = datos;
		this.Cedula = cedula;
		this.Nombre = nombre;
		this.fondosDisponibles = fondosDisponibles;
		this.tipoSuscripcion = tipoSuscripcion;
		this.facSin_pagar = facSin_pagar;
		this.personasAutorizadas = personasAutorizadas;
	}

	public String getDatos() {
		return Datos;
	}

	public void setDatos(String datos) {
		Datos = datos;
	}

	public String getNombre() {
		return Nombre;
	}

	public String setNombre(String id) {
		String nombre = "";
		for (int i=0; i<matrizMembers.length;i++) {
			if (matrizMembers[i][0] != null && matrizMembers[i][0].equals(id)) {
				nombre = matrizMembers[i][1];
				}
		}
		return nombre;
	}

	public String getFondosDisponibles() {
		return fondosDisponibles;
	}

	public void setFondosDisponibles(String fondosDisponibles) {
		this.fondosDisponibles = fondosDisponibles;
	}

	public String getTipoSuscripcion() {
		return tipoSuscripcion;
	}

	public void setTipoSuscripcion(String tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}

	public String getFacSin_pagar() {
		return facSin_pagar;
	}

	public void setFacSin_pagar(String facSin_pagar) {
		this.facSin_pagar = facSin_pagar;
	}

	public String getPersonasAutorizadas() {
		return personasAutorizadas;
	}

	public void setPersonasAutorizadas(String personasAutorizadas) {
		this.personasAutorizadas = personasAutorizadas;
	}
	
    public int memberExisting(String id){
    	int existing = 0;
    	for (int i=0; i<matrizMembers.length;i++) {
			if (matrizMembers[i][0] != null && matrizMembers[i][0].equals(id)) {
					existing =1;
				}
		}
    	return existing;
    }
    
	public void addMembers(String Cedula,String Nombre, String fondosDisponibles, String tipoSuscripcion, String Datos) {
		    int i = this.count();
			this.matrizMembers[i][0] = Cedula;
			this.matrizMembers[i][1] = Nombre;
			this.matrizMembers[i][2] = fondosDisponibles;
			this.matrizMembers[i][3] = tipoSuscripcion;
			this.matrizMembers[i][4] = Datos; 
	}
    
	public int count() {
		int count = 0;
		for (int i=0; i<matrizMembers.length;i++) {
			if(this.matrizMembers[i][0] != null) {
				count = count + 1;
			}
		}
		return count;
	}
	
	public String[][] getMember(){
		return this.matrizMembers;
	}
	
	public boolean deleteMember(String id) {
		
		boolean deleted = false;
		for (int i=0; i<this.count(); i++) {
			
				if (this.matrizMembers[i][0]!= null && this.matrizMembers[i][0].equals(id) ) {
					 deleted = true; 
					 this.matrizMembers[i][0] = this.matrizMembers[i+1][0];
					 this.matrizMembers[i][1] = this.matrizMembers[i+1][1];
					 this.matrizMembers[i][2] = this.matrizMembers[i+1][2];
					 this.matrizMembers[i][3] = this.matrizMembers[i+1][3];
					 this.matrizMembers[i][4] = this.matrizMembers[i+1][4];
					 i++;
			     }
		}
		return deleted;
		
	}
	
	public String increaseFund(String id, int value){
    	int newValue = 0;
    	String menssage = "Your balance was not updated";
    	for (int i=0; i<matrizMembers.length;i++) {
			if (matrizMembers[i][0] != null && matrizMembers[i][0].equals(id)) {
				newValue = Integer.parseInt( matrizMembers[i][2]) + value;
				if (newValue<=5000000 && matrizMembers[i][3].equals("vip") || matrizMembers[i][3].equals("regular") && newValue<=1000000) {
				matrizMembers[i][2] = String.valueOf(newValue);
				menssage = "Your balance wass update. It is " + newValue;
				}
				
			}
		}
    	return menssage;
    }
	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

