package uniandes.cupi2.sistemapacientes.interfaz;
import uniandes.cupi2.sistemapacientes.mundo.*;
import javax.swing.*;
import java.awt.BorderLayout;
//POR JOHAN NIETO
public class InterfazSistemaPacientes extends JFrame {

	
	
	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz= new InterfazSistemaPacientes();
		interfaz.setVisible(true);
	}
	
	private SistemaPacientes sistemaPacientes;
	
	private PanelDatosPaciente panelDatosPaciente;
	private PanelDatosMuestra panelDatosMuestra;
	private PanelExtensiones panelExtensiones;
	
	public InterfazSistemaPacientes() {
		setTitle("Sistema de Pacientes");
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		sistemaPacientes= new SistemaPacientes();
		
		panelDatosPaciente= new PanelDatosPaciente(this);
		panelDatosMuestra= new PanelDatosMuestra(this);
		panelExtensiones= new PanelExtensiones(this);
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}
	
	public void actualizarInfoPaciente(Paciente pPaciente) {
		String nombre= pPaciente.darNombre();
		String Apellido= pPaciente.darApellido();
		
		String sexo="F";
		
		if(pPaciente.darSexo()==2) {
			sexo="M";
		}
		
		String fechaMuestra= pPaciente.darFechaTomaMuestra();
		String fechaNacimiento= pPaciente.darFechaNacimiento();
		String Imagen= pPaciente.darImagen();
		double volumenMuestra= pPaciente.darVolumenMuestra();
		double volumenEritrocitos= pPaciente.darVolumenEritrocitos();
		int conteoLeucocitos= pPaciente.darConteoLeucocitos();
		int conteoPlaquetas= pPaciente.darConteoPlaquetas();
		boolean enAyunas=pPaciente.darEnAyunas();
		
		panelDatosPaciente.actualizarCampos(nombre, Apellido, sexo, fechaNacimiento, Imagen);
		panelDatosMuestra.actualizarCampos(fechaMuestra, enAyunas, volumenMuestra, volumenEritrocitos, conteoLeucocitos, conteoPlaquetas);
		panelDatosMuestra.limpiarCampos();
	}
	
	public void avanzar() {
		Paciente pacienteActual= sistemaPacientes.darPacienteSiguiente();
		actualizarInfoPaciente(pacienteActual);
	}
	
	public void retroceder() {
		Paciente pacienteActual= sistemaPacientes.darPacienteAnterior();
		actualizarInfoPaciente(pacienteActual);
	}
	
	public void calcularHematocrito() {
		String pVolumenMuestra=panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos=panelDatosMuestra.darVolumenEritrocitos();
		
		if(pVolumenMuestra.trim().equals("")|| pVolumenEritrocitos.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.","Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);
		}else if(pVolumenMuestra.trim().matches("[0123456789.]*") && pVolumenEritrocitos.trim().matches("[0123456789.]*")) {
			
			double volumenMuestra= Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos= Double.parseDouble(pVolumenEritrocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			
			double hematocrito= sistemaPacientes.darPacienteActual().calcularHematocrito();
			hematocrito= Math.round(hematocrito*100)/100;
			panelDatosMuestra.mostrarHematocrito(hematocrito+"");
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.","Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void cambiarEnAyunas() {
		if(panelDatosMuestra.estaEnAyunas()) {
			JOptionPane.showMessageDialog(this, "En ayunas.","Estado",JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "No en ayunas.","Estado",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void reqFuncionOpcion1() {
		String resultado= sistemaPacientes.metodo1();
		JOptionPane.showMessageDialog(this,resultado,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reqFuncionOpcion2() {
		String resultado= sistemaPacientes.metodo2();
		JOptionPane.showMessageDialog(this,resultado,"Respuesta",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void calcularEdad() {
		int edad= sistemaPacientes.darPacienteActual().darEdad();
		panelDatosPaciente.mostrarEdad(edad+"");
	}
	
	public void calcularLeucocitos() {
		String pVolumenMuestra=panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos=panelDatosMuestra.darVolumenEritrocitos();
		String pConteoLeucocitos=panelDatosMuestra.darConteoLeucocitos();
		
		if(pVolumenMuestra.trim().equals("")|| pVolumenEritrocitos.trim().equals("") || pConteoLeucocitos.trim().equals("") ) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.","Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);
		}else if(pVolumenMuestra.trim().matches("[0123456789.]*") && pVolumenEritrocitos.trim().matches("[0123456789.]*") && pConteoLeucocitos.trim().matches("[123456789.]*")) {
			
			double volumenMuestra= Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos= Double.parseDouble(pVolumenEritrocitos.trim());
			int conteoLeucocitos= Integer.parseInt(pConteoLeucocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);
			
			double leucocitos= sistemaPacientes.darPacienteActual().calcularLeucocitos();
			leucocitos= Math.round(leucocitos*100)/100;
			panelDatosMuestra.mostrarLeucocito(leucocitos+"");
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.","Calcular Hematocrito",JOptionPane.ERROR_MESSAGE);
		}	
	}
}
