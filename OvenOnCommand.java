package finalProject;

public class OvenOnCommand implements Command{
	Oven oven;
	public OvenOnCommand(Oven oven) 
    { 
       this.oven = oven; 
    } 
    public void execute() 
    { 
    	oven.on(); 
    } 
    
}
