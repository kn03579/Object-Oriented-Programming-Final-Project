package finalProject;

public class Mixer {
	String name;
	int speed;
	
	public Mixer(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}
	public void on() {
		ObjectOrientedGUI.applianceStatus.appendText(getName() + " is on and set to speed " + getSpeed()+"\n");
	}
	public void off() {
		ObjectOrientedGUI.applianceStatus.appendText(getName() + " is off "+"\n");
	}
	public String getName() {
		return this.name;
	}
	public int getSpeed() {
		return this.speed;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
