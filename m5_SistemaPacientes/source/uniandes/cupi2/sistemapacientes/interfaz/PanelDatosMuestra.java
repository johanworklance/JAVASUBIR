
package uniandes.cupi2.sistemapacientes.interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel implements ActionListener{
	
	
	private static final String AYUNAS= "En ayunas";
	private static final String CALCULAR_HEMATOCRITO= "CALCULAR HEMATOCRITO";
	private static final String CALCULAR_LEUCOCITOS= "CALCULAR LEUCOCITOS";
	
	
	private JLabel labFTomaMuestra;
	private JTextField txtFTomaMuestra;
	
	private JLabel labVolumenMuestra;
	private JTextField txtVolumenMuestra;
	
	private JLabel labVolumenEritrocitos;
	private JTextField txtVolumenEritrocitos;
	
	private JLabel labConteoLeucocitos;
	private JTextField txtConteoLeucocitos;
	
	private JLabel labConteoPlaquetas;
	private JTextField txtConteoPlaquetas;
	
	private JCheckBox cbAyunas;
	
	private JButton butHematocrito;
	private JTextField txtHematocrito;
	
	private JButton butLeucocitos;
	private JTextField txtLeucocitos;
	
	private InterfazSistemaPacientes principal;
	
	
	public PanelDatosMuestra(InterfazSistemaPacientes v){
		principal=v;
		setLayout(new GridLayout(6,4));
		TitledBorder border= BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		labFTomaMuestra= new JLabel("Fecha Toma Muestra: ");
		labVolumenMuestra= new JLabel("Volumen Muestra: ");
		labVolumenEritrocitos= new JLabel("Volumen Eritrocitos: ");
		labConteoLeucocitos= new JLabel("Conteo Leucocitos: ");
		labConteoPlaquetas= new JLabel("Conteo Leucocitos: ");
		
		txtFTomaMuestra= new JTextField();
		txtFTomaMuestra.setEditable(false);
		txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);
		txtFTomaMuestra.setForeground(Color.BLUE);
		
		txtVolumenMuestra= new JTextField();
		txtVolumenMuestra.setEditable(true);
		txtVolumenMuestra.setBackground(Color.WHITE);
		txtVolumenMuestra.setForeground(Color.BLACK);
		
		txtVolumenEritrocitos= new JTextField();
		txtVolumenEritrocitos.setEditable(true);
		txtVolumenEritrocitos.setBackground(Color.WHITE);
		txtVolumenEritrocitos.setForeground(Color.BLACK);
		
		txtConteoLeucocitos= new JTextField();
		txtConteoLeucocitos.setEditable(true);
		txtConteoLeucocitos.setBackground(Color.WHITE);
		txtConteoLeucocitos.setForeground(Color.BLACK);
		
		txtConteoPlaquetas= new JTextField();
		txtConteoPlaquetas.setEditable(true);
		txtConteoPlaquetas.setBackground(Color.WHITE);
		txtConteoPlaquetas.setForeground(Color.BLACK);
		
		cbAyunas= new JCheckBox("Ayunas");
		cbAyunas.setActionCommand(AYUNAS);
		cbAyunas.addActionListener(this);
		
		butHematocrito= new JButton("Calcular Hematocrito: ");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
		butHematocrito.addActionListener(this);
		txtHematocrito= new JTextField();
		txtHematocrito.setEditable(false);
		
		butLeucocitos= new JButton("Calcular Leucocitos: ");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
		butLeucocitos.addActionListener(this);
		txtLeucocitos= new JTextField();
		txtLeucocitos.setEditable(false);
		
		add(labFTomaMuestra);
		add(txtFTomaMuestra);
		add(new JLabel(""));
		add(cbAyunas);
		add(labVolumenMuestra);
		add(txtVolumenMuestra);
		add(new JLabel(""));
		add(new JLabel(""));
		add(labVolumenEritrocitos);
		add(txtVolumenEritrocitos);
		add(butHematocrito);
		add(txtHematocrito);
		add(labConteoLeucocitos);
		add(txtConteoLeucocitos);
		add(butLeucocitos);
		add(txtLeucocitos);
		add(labConteoPlaquetas);
		add(txtConteoPlaquetas);
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		
		
	}
	
	public void actionPerformed( ActionEvent e ) {
		 String comando= e.getActionCommand();
		 if(comando.equals(CALCULAR_HEMATOCRITO)){
			 principal.calcularHematocrito();
		 }else if(comando.equals(CALCULAR_LEUCOCITOS)) {
			 principal.calcularLeucocitos();
		 }else if(comando.equals(AYUNAS)) {
			 principal.cambiarEnAyunas();
		 }
	 }
	
	public void mostrarHematocrito(String pHematocrito) {
		txtHematocrito.setText(pHematocrito+"");
	}
	public void mostrarLeucocito(String pLeucocito) {
		txtLeucocitos.setText(pLeucocito+"");
	}
	public void mostrarAyunas(boolean pEnAyunas) {
		cbAyunas.setSelected(pEnAyunas);
	}
	
	public String darVolumenMuestra() {
		String rta= txtVolumenMuestra.getText();
		return rta;
	}
	public String darVolumenEritrocitos() {
		String rta= txtVolumenEritrocitos.getText();
		return rta;
	}public String darConteoLeucocitos() {
		String rta= txtConteoLeucocitos.getText();
		return rta;
	}public String darConteoPlaquetas() {
		String rta= txtConteoPlaquetas.getText();
		return rta;
	}
	
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();
	}
	
	public void limpiarCampos() {
		 txtHematocrito.setText("");
		 txtLeucocitos.setText("");
	 }
	
	public void actualizarCampos(String pFechaMuestra,boolean pEnAyunas,double pVolumenMuestra,double pVolumenEritrocitos,int pConteoLeucocitos,int pConteoPlaquetas) {
		txtFTomaMuestra.setText(pFechaMuestra);
		txtVolumenMuestra.setText(pVolumenMuestra+"");
		txtVolumenEritrocitos.setText(pVolumenEritrocitos+"");
		txtConteoLeucocitos.setText(pConteoLeucocitos+"");
		txtConteoPlaquetas.setText(pConteoPlaquetas+"");
		cbAyunas.setSelected(pEnAyunas);
		
	}
}
