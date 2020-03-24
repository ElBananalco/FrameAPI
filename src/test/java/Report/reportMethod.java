package Report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Frame.TestData;
import Frame.TestMethods;

public class reportMethod {
	//Initialize FileWrite and PrintWriter to write HTML
	FileWriter filewriter = null;
	 PrintWriter printw = null;
	 //We create a method to create a report
	public void reportMaker(ArrayList<TestData> stepList) {
		//A printer is created
		try{
			//declare the file location
		     filewriter = new FileWriter("C:\\Users\\jorge\\eclipse-workspace\\01\\src\\test\\java\\Reporthtl\\reporte.html");
		     //Create a print object to write the html code
		     printw = new PrintWriter(filewriter);
		     //Initialize the html doc 
		     printw.println("<html>");
		     printw.println("<head><title>Reporte</title> "
		     		+"<link rel=\"icon\" href=\"../img/Thanos.png\" />" + 
		     		"<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">" + 
		     		"<link rel=\"stylesheet\" href=\"../css/estilos.css\">" + 
		     		"<script src=\"../js/jquery-3.4.1.min.js\"></script>" + 
		     		"<script src=\"../js/bootstrap.min.js\"></script>"
		     		+ "</head>");    
		     printw.println("<body>");
		    
		     //navigation bar creation
		     printw.println("<nav class=\"navbar-custom\">" + 
		     		"    <a class=\"navbar-brand\" href=\"#\">" + 
		     		"      <img src=\"../img/iconfinder_JD-27_2624867.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\">" + 
		     		"      Thanos Framework" + 
		     		"    </a>" + 
		     		"  </nav>");
	
		     //A table and their headers are created.
		     printw.println(" <div>" + 
		     		"    <table class=\"table table-hover\">" + 
		     		"        <thead>" + 
		     		"          <tr>" + 
		     		"            <th scope=\"col\">Test Case Name</th>" + 
		     		"            <th scope=\"col\">Expected/Accion</th>" + 
		     		"            <th scope=\"col\">Status</th>" + 
		     		"            <th>Body</th>" + 
		     		"            <th>Path</th>" + 
		     		"			<th>Status Code Return</th>"	+
		     		"          </tr>" + 
		     		"        </thead>"
		     		);
		     //All the steps from their respective test cases are printed by a for cycle
		     TestMethods run = new TestMethods();
		     
		     for(int i = 0; i < stepList.size(); i++)
		     {	 String statusCode="";    
		    	statusCode = run.executionFile(stepList.get(i));
		    	 printw.println("<tbody>" + "<tr>");
		    	 printw.println("<th scope=\"row\">" + stepList.get(i).nameTC + "</th>"+ 
		    			 "<th scope=\"row\">" + stepList.get(i).expected + "/" + stepList.get(i).accion + "</th>"+ 
		    	 		"<td>" + run.validationCode() + "</td>"+ 
		    	 		"<td>" + stepList.get(i).body + "</td>" + 
		    	 		"<td>" + stepList.get(i).path + "</td>"	+ 
		    	 		"<td>" + statusCode + "</td>"
		    	 		//"<td>" + run.validationCode() + "</td>"
		    	 		);
		    	 //here verifies if an step passed or not 
//		    	 if(stepList.get(i).isPass() == true) {
//		    		 printw.println("<td><span><img src=\"../img/pass-icon.png\" height=\"30\" width=\"30\"></span></td>");
//		    	 }else {
//		    		 printw.println("<td><span><img src=\"../img/failed-icon.png\" height=\"30\" width=\"30\"></span></td>");
//		    	 }
		    	 		
		    	 	printw.println(""
		    	 			
		    	 	+ "</div>");
		     }
		     //we close the html code.
		     printw.println("</body>");
		     printw.println("</html>");
		     printw.close();//we close the print object.
		     System.out.println("Reporte generado exitosamente");//If everything success will send a console message.
	}catch(IOException e){ //If it fails will send a message with the exception.
		e.getMessage();
	}
	}
}
