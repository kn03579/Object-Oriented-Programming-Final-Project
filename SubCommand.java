package finalProject;

public class SubCommand implements Command{
	Command[] commands;
	
	public SubCommand(Command[] commands) {
		this.commands = commands;
	}
	
	public void execute() {
		for(int i=0; i < commands.length; i++) {
			commands[i].execute();
		}
	}
	
}
