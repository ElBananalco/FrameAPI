package Report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenHtml {
	/** This method open the report */
	public void OpenHtml(String nombreTC) throws IOException {
	File objectfile = new File ("src/test/java/Reporthtl/"+nombreTC+".html");
		 Desktop.getDesktop().open(objectfile);
	}
}
