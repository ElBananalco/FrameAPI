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
		ArrayList<TestData> ListObjectTestC = new ArrayList();
		ArrayList<TestData> ListNew = new ArrayList();

		/** create this object to read the file xlxs */
		Read TC = new Read();

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

		/** Save the Test cases in this array */
		ListObjectTestC = TC.getObjects(uri);

		/** The array namesTc save to names the Test cases */
		String[] namesTc;
		namesTc = TC.getSheetsNames(uri);

		/** this array saves the buttons that we will use */
		JRadioButton[] radio = new JRadioButton[ListObjectTestC.size()];

		/** We create a Panel(Interface) */
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel label = new JLabel();
		label.setText("Wich Test Cases wish execute");
		panel.add(label);
		panel.setBounds(10, 10, 375, 150);

		/** This for create and add to array radio all the buttons that we will show */
		String name = "";
		for (int u = 0; u < namesTc.length; u++) {

			name = namesTc[u];
			if (name != null) {
				JRadioButton button = new JRadioButton(name);
				radio[u] = button;
				panel.add(radio[u]);
			}

		}

		/** Show the Panel */
		JOptionPane.showMessageDialog(null, panel);

		/** This for save the selected Test cases */
		String[] tcSelected = new String[radio.length];
		for (int t = 0; t < radio.length; t++) {

			if (radio[t].isSelected()) {

				tcSelected[t] = radio[t].getLabel();

			}
		}

		/** Save the selected test cases in array ListNew using the method getTC. */
		for (int sheet = 0; sheet < tcSelected.length; sheet++) {

			if (tcSelected[sheet] == null) {

			} else {

				ListNew = TC.getTC(uri, tcSelected[sheet]);
			}
		}

		/** Create the objects for open and execute the report */
		OpenHtml openHtml = new OpenHtml();
		reportMethod report = new reportMethod();
		
		/** Send the ListNew for generate the report*/
		report.reportMaker(ListNew);
		/** Opens the report */
		openHtml.OpenHtml(ListNew.get(0).getNameTC());

	}

}
