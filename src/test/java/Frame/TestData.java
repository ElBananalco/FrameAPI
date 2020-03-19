package Frame;
public class TestData {

	public String accion;
	public String body;
	public int expected;
	public String nameTC;
	public String path;
	
	public TestData(String nameTC, String accion, String body, int expected,String path) {
		this.accion=accion;
		this.body=body;
		this.expected=expected;
		this.nameTC=nameTC;
		this.path=path;
	}
	
	public TestData(String nameTC) {
	
		this.nameTC=nameTC;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBody() {
		return body;
	}

	public String getNameTC() {
		return nameTC;
	}

	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	@Override
	public String toString() {
		return "TestData [accion=" + accion + ", body=" + body + ", expected=" + expected + ", nameTC=" + nameTC
				+ ", path=" + path + "]";
	}

	
	
	
	
}
