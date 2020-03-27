package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Report.OpenHtml;
import Report.reportMethod;
import junit.framework.TestCase;

public class Runner extends TestCase {

	public static void main(String args[]) throws IOException {
		
		/** initialize the arrays to save the test cases */
		ArrayList<TestData> ListaObjetosTestC = new ArrayList();
     	ArrayList<TestData> ListaTemp = new ArrayList();

		/** create this object to read the file xlxs */
		leer TC = new leer();

		/** This method save to url (Where the Test case is located) */
		javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
		String uri = "";
		try {
			if (jF1.showSaveDialog(null) == jF1.APPROVE_OPTION) {
				
				uri = jF1.getSelectedFile().getAbsolutePath();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/** Save the Test cases in this array*/
		ListaObjetosTestC = TC.obtenerObjetos(uri);

		
		/** The array namesTc save to names the Test cases */
		String[] namesTc ;
		namesTc=TC.getSheetsNames(uri);

		/** this array saves the buttons that we will use */
		JRadioButton[] radio = new JRadioButton[ListaObjetosTestC.size()];

		String name = "";
		// creamos la pantalla
		JPanel panel = new JPanel();

		// le damos formato
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel label = new JLabel();
		label.setText("Cuales TC deseas ejecutar");
		panel.add(label);
		// Se le asigna una posición dentro del Jpanel
		panel.setBounds(10, 10, 375, 150);

		// en este for recorremos el arreglo de prueba para crear los radio button con
		// los
		// nonbres de los TC
		for (int u = 0; u < namesTc.length; u++) {
			
			name = namesTc[u];
			
			if(name != null) {
			JRadioButton button = new JRadioButton(name);
			radio[u] = button;

			// agregamos el radiobutton al panel
			panel.add(radio[u]);}
			

		}

		// mostramos el panel
		JOptionPane.showMessageDialog(null, panel);

		// este arreglo sera para guardar los que seleccionemos
		String[] cad = new String[radio.length];

		// este for recorre el arreglo de los radio buttons para checar quien fue
		// seleccionado
		for (int t = 0; t < radio.length; t++) {
			
			// preguntamos si fue seleccionado
			if (radio[t].isSelected()) {
				// guardamos el nombre del TC en el arreglo cad
				cad[t] = radio[t].getLabel();
				
			}
		}
		
		/*creamos los objetos para hacer el reporte y abrirlo*/
		 OpenHtml openHtml=new OpenHtml();
		 reportMethod report= new reportMethod();
		
		// juntamos los TC seleccionados en el arraylist
		for (int sheet = 0; sheet < cad.length; sheet++) {
			
			if (cad[sheet] == null) {

			} else {
				// el metdodo obtenerTC carga al array la hoja que le mandamos
				ListaTemp = TC.obtenerTC(uri, cad[sheet]);
			
			}

		}
	
		
		

		//Enviamos la lista con los TC selecionados para que se ejecuten y genere un reporte
		report.reportMaker(ListaTemp);
		/**Opens the report*/
		openHtml.OpenHtml(ListaTemp.get(0).getNameTC());
	
}

}
