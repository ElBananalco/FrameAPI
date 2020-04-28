package Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;





public class Read {
	static ArrayList<TestData> TC = new ArrayList();
	static ArrayList<TestData> Names = new ArrayList();
	static XSSFRow row;

	
	/** This method get the Test cases from file xlsx*/
	@Test 
	public ArrayList<TestData> getObjects(String URL) throws IOException {

		FileInputStream fis = new FileInputStream(new File(URL));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		/** get the quantity the sheets*/
		 int Hojas = workbook.getNumberOfSheets(); 
			XSSFSheet spreadsheet;
			
			
		 for(int i = 0;i<Hojas;i++) {
			 spreadsheet = workbook.getSheetAt(i);
	 

		int rows=0;
		
		/**get the quantity the rows*/
		rows = spreadsheet.getLastRowNum()+1;

		int cols = 0;
		
		TestData aux;
		double step=0.0;
		String Body = "",accion="",nameTc="",path="";
				double expected=0.0;
				int exp=0;
		
				
				/** This for create the object with the data from file xlsx**/
		for (int r = 0; r < rows; r++) {
			row = spreadsheet.getRow(r);
			if(row.getLastCellNum()==0) {
			
			}
			for (int c = 0; c < (cols = row.getLastCellNum()); c++) {

				if (row.getCell(c) == null) {
					break;
				} else {
					if (r > 0) {
						switch (c) {
						
						case 0:
							step = row.getCell(c).getNumericCellValue();
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
			
			int stepAux=(int)step;
			nameTc=workbook.getSheetName(i);
			aux = new TestData(stepAux,accion,Body,exp,path,nameTc);
			if(aux.getNameTC()=="") {
				
			}else {
				TC.add(aux);		
				
				nameTc="";
				accion = "";
				Body="";
				exp=0;
				path="";
				step=0;
				stepAux=0;
				
			}
				
			
			
		}
		
		 }
		 for(int index=0;index<TC.size();index++) {
				
				if(TC.get(index).getStep() == 0) {
				TC.remove(index);
				}
				}
			
		fis.close();
		return TC;

	}
	/** This method return the Sheet names*/
	public String[] getSheetsNames(String URL) throws IOException {
		 
		 FileInputStream fis = new FileInputStream(new File(URL));

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			 int Hojas = workbook.getNumberOfSheets(); 
			 String[] Sheetname = new String[Hojas];
			
				
				
			 for(int i = 0;i<Hojas;i++) {
				 Sheetname[i]= workbook.getSheetName(i);
			 }
		 return Sheetname;
	 }
	
	/** This method return the array specifically with the sheet that we send */
	@Test
	public ArrayList<TestData> getTC(String URL,String sheet) throws IOException {

		FileInputStream fis = new FileInputStream(new File(URL));

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		 int Hojas = workbook.getNumberOfSheets(); 
			XSSFSheet spreadsheet;
			
			spreadsheet = workbook.getSheet(sheet);
		 


		int rows=0;
		 rows = spreadsheet.getLastRowNum()+1;

		
		int cols = 0;
		
		TestData auxN;
		double step=0.0;
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
							step = row.getCell(c).getNumericCellValue();
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
			
			int stepAux=(int)step;
			nameTc=sheet;
			auxN = new TestData(stepAux,accion,Body,exp,path,nameTc);
			if(auxN.getNameTC()=="") {
					
			}else
				Names.add(auxN);
			
			nameTc="";
			accion = "";
			Body="";
			exp=0;
			path="";
			step=0.0;
			stepAux=0;
			
			
			
		}
		for(int index=0;index<Names.size();index++) {
		
		if(Names.get(index).getStep() == 0) {
		Names.remove(index);
		}
		}
		fis.close();
		return Names;

	}
	

}
