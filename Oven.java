package finalProject;

public class Oven {
	String name;
	int temp;
	
	public Oven(String name, int temp) {
		this.name = name;
		this.temp = temp;
	}
	public void on() {
		ObjectOrientedGUI.applianceStatus.appendText(getName() + " is on and set to " + getTemp() + " degrees"+"\n");
	}
	public void off() {
		ObjectOrientedGUI.applianceStatus.appendText(getName() + " is off "+"\n");
	}
	public String getName() {
		return this.name;
	}
	public int getTemp() {
		return this.temp;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
}	
