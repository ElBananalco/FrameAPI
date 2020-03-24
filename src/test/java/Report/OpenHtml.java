package Report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenHtml {
	public File objectfile = new File ("C:\\Users\\jorge\\eclipse-workspace\\01\\src\\test\\java\\Reporthtl\\reporte.html");
	public void OpenHtml() throws IOException {
		 Desktop.getDesktop().open(objectfile);
	}
}
