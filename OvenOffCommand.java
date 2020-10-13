package finalProject;

public class OvenOffCommand implements Command {
	Oven oven;

	public OvenOffCommand(Oven oven) {
		this.oven = oven;
	}

	public void execute() {
		oven.off();
	}

}
