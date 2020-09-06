package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVozIP extends LineaTelefonica {
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
     * Número de minutos celulares consumidos.
     */
	private int numeroMinutosCelular;
	/**
     * Número de minutos de larga distancia consumidos.
     */
	private int numeroMinutosLargaDistancia;
	
	/**
     * Saldo o dinero disponible para realizar llamadas celular y larga 
     * distancia.
     */
	private double saldoDisponible;
	
	public LineaVozIP() {
		super();
		numeroMinutosCelular=0;
		numeroMinutosLargaDistancia=0;
		saldoDisponible=100000;
		
	}
	public void reiniciar() {
		super.reiniciar();
			numeroMinutosCelular=0;
			numeroMinutosLargaDistancia=0;
			saldoDisponible=100000;
		
	}
	
	public int darNumeroMinutosLargaDistancia() {
		return numeroMinutosLargaDistancia;
	}
	
	public int darNumeroMinutosCelular() {
		return numeroMinutosCelular;
	}
	
	public double darSaldoDisponible() {
		return saldoDisponible;
	}
	
	public void agregarLlamadaCelular( int minutos )
    {
    	
    	super.agregarLlamadaCelular(minutos);
    	
    	
    	modificarCostoLlamada( darCostoLlamadas() - minutos*992);
    	
        
        numeroMinutosCelular = numeroMinutosCelular + minutos;
        
        saldoDisponible-= minutos*7;
    }  
	
	 public void agregarLlamadaLargaDistancia( int minutos )
	    {
	        super.agregarLlamadaLargaDistancia( minutos );
	        modificarCostoLlamada( darCostoLlamadas() - minutos*300);
	        numeroMinutosLargaDistancia+=minutos;
	        saldoDisponible-= minutos*80;
	    }
}
