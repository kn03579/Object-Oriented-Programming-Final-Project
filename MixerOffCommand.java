package finalProject;

public class MixerOffCommand implements Command{
	Mixer mixer;
	public MixerOffCommand(Mixer mixer) 
    { 
       this.mixer = mixer; 
    } 
    public void execute() 
    { 
    	mixer.off(); 
    } 
}
