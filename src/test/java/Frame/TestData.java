package Frame;
public class TestData {

	/**the action is the method (POST, PUT, GET)*/
	public String action;
	/** The body is the structure for execute*/
	public String body;
	/** Is the status code that expected */
	public int expected;
	/** Test Case name */
	public String nameTC;
	/**The path that we will use*/
	public String path;
	
	public int step;
	
	/** The constructor save the data from file xlxs
	 * @param nameTC */
	public TestData(int step, String action, String body, int expected,String path, String nameTC) {
		this.step=step;
		this.action=action;
		this.body=body;
		this.expected=expected;
		this.nameTC=nameTC;
		this.path=path;
	}
	
	
	
	public int getStep() {
		return step;
	}



	public void setStep(int step) {
		this.step = step;
	}



	/**Get the action*/
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	/**Get the Path*/
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	/**Get the Body*/
	public String getBody() {
		return body;
	}
	/**Get the Test cases name*/
	public String getNameTC() {
		return nameTC;
	}

	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}

	public void setBody(String body) {
		this.body = body;
	}
	/**Get the status code expected*/
	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	
	/** Return format for the Object TestData*/
	@Override
	public String toString() {
		return "TestData [accion=" + action + ", body=" + body + ", expected=" + expected + ", nameTC=" + nameTC
				+ ", path=" + path + "]";
	}

	
	
	
	
}
