package Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;





public class leer {
	static ArrayList<TestData> TC = new ArrayList();
	static ArrayList<TestData> Names = new ArrayList();
	static XSSFRow row;

	@Test
	public ArrayList<TestData> obtenerObjetos(String URL) throws IOException {

		FileInputStream fis = new FileInputStream(new File(URL));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		 int Hojas = workbook.getNumberOfSheets(); 
			XSSFSheet spreadsheet;
			
			//recorremos las hojas-------------------------
			//se recorrera con el tama;o del array de sheets
		 for(int i = 0;i<Hojas;i++) {
			 spreadsheet = workbook.getSheetAt(i);
		 


		int rows=2;
		//rows = spreadsheet.getLastRowNum();

		// Obtengo el número de columnas ocupadas en la hoja
		int cols = 0;
		
		TestData aux;
		
		String Body = "",accion="",nameTc="",path="";
				double expected=0.0;
				int exp=0;
		
		for (int r = 0; r < rows; r++) {
			row = spreadsheet.getRow(r);

			for (int c = 0; c < (cols = row.getLastCellNum()); c++) {

				if (row.getCell(c) == null) {

				} else {
					if (r > 0) {
						switch (c) {
						
						case 0:
							nameTc = row.getCell(c).getStringCellValue();
							//System.out.print(nameTc);
							break;

						case 1:
							accion = row.getCell(c).getStringCellValue();
							//System.out.print(accion);
							break;

						
						case 2:
							Body = row.getCell(c).getStringCellValue();
							//System.out.print(Body);
							break;
							
							
						case 3:
							expected = row.getCell(c).getNumericCellValue();
							exp = (int)expected;
							//System.out.print(exp);
							break;

						case 4:
							path = row.getCell(c).getStringCellValue();
							//System.out.print(path);
							break;


						}
					}

				}
			}
			
			
			aux = new TestData(nameTc,accion,Body,exp,path);
		
			TC.add(aux);		
			
			nameTc="";
			accion = "";
			Body="";
			exp=0;
			path="";
		}
		//System.out.print(TC.toString());
		 }
			
		fis.close();
		return TC;

	}
	
	
	//////////////////////////////////////////
	@Test
	public ArrayList<TestData> obtenerTC(String URL,String sheet) throws IOException {

		FileInputStream fis = new FileInputStream(new File(URL));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		 int Hojas = workbook.getNumberOfSheets(); 
			XSSFSheet spreadsheet;
			
			//recorremos las hojas-------------------------
			//se recorrera con el tama;o del array de sheets
	
			 spreadsheet = workbook.getSheet(sheet);
		 


		int rows=2;
		//rows = spreadsheet.getLastRowNum();

		// Obtengo el número de columnas ocupadas en la hoja
		int cols = 0;
		
		TestData auxN;
		
		String Body = "",accion="",nameTc="",path="";
		double expected=0.0;
		int exp=0;
				
		
		for (int r = 0; r < rows; r++) {
			row = spreadsheet.getRow(r);

			for (int c = 0; c < (cols = row.getLastCellNum()); c++) {

				if (row.getCell(c) == null) {

				} else {
					if (r > 0) {
						switch (c) {
						
						case 0:
							nameTc = row.getCell(c).getStringCellValue();
							//System.out.print(nameTc);
							break;

						case 1:
							accion = row.getCell(c).getStringCellValue();
							//System.out.print(accion);
							break;

						
						case 2:
							Body = row.getCell(c).getStringCellValue();
							//System.out.print(Body);
							break;
							
							
						case 3:
							expected = row.getCell(c).getNumericCellValue();
							exp = (int)expected;
							//System.out.print(exp);
							break;
							
						case 4:
							path = row.getCell(c).getStringCellValue();
							//System.out.print(path);
							break;


						}
					}

				}
			}
			
			
			auxN = new TestData(nameTc,accion,Body,exp,path);
			
			Names.add(auxN);		
			
			
			nameTc="";
			accion = "";
			Body="";
			exp=0;
			path="";
			
		}
		//System.out.print(TC.toString());
		 
			
		fis.close();
		return Names;

	}
	

}
