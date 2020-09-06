
package uniandes.cupi2.sistemapacientes.interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener{

	private static final String AVANZAR= "AVANZAR";
	private static final String RETROCEDER= "RETROCEDER";
	private static final String OPCION_1= "opcion1";
	private static final String OPCION_2= "opcion2";
	
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	private JButton btnOpcion1;
	private JButton btnOpcion2;
	
	private InterfazSistemaPacientes principal;
	
	public PanelExtensiones(InterfazSistemaPacientes v){
		principal=v;
		setLayout(new FlowLayout());
		TitledBorder border= BorderFactory.createTitledBorder("Puntos de extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		btnAvanzar= new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		btnAvanzar.addActionListener(this);
		btnRetroceder= new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		btnRetroceder.addActionListener(this);
		btnOpcion1= new JButton("Opción 1");
		btnOpcion1.setActionCommand(OPCION_1);
		btnOpcion1.addActionListener(this);
		btnOpcion2= new JButton("Opción 2");
		btnOpcion2.setActionCommand(OPCION_2);
		btnOpcion2.addActionListener(this);
		
		add(btnRetroceder);
		add(btnOpcion1);
		add(btnOpcion2);
		add(btnAvanzar);
	}
	
	public void actionPerformed( ActionEvent e ) {
		 String comando= e.getActionCommand();
		 if(comando.equals(AVANZAR)){
			 principal.avanzar();
		 }else if(comando.equals(RETROCEDER)) {
			 principal.retroceder();
		 }else if(comando.equals(OPCION_1)) {
			 principal.reqFuncionOpcion1();
		 }else if(comando.equals(OPCION_2)) {
			 principal.reqFuncionOpcion2();
		 }
	 }
	
	
}
