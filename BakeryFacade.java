package finalProject;

public class BakeryFacade {
	static Mixer mixer;
	static Oven oven;
	static RemoteControl remotecontrol;
	
	public BakeryFacade(Mixer m, Oven o, RemoteControl rc) {
		mixer = m;
		oven = o;
		remotecontrol = rc;
	}
	
	public void initialize() {
		OvenOnCommand ovenOn = new OvenOnCommand(oven);
		OvenOffCommand ovenOff = new OvenOffCommand(oven);
		
		MixerOnCommand mixOn = new MixerOnCommand(mixer);
		MixerOffCommand mixOff = new MixerOffCommand(mixer);
		
		Command[] partyOn = {mixOn, ovenOn};
		Command[] partyOff = {mixOff, ovenOff};
		
		SubCommand partyOnSubCom = new SubCommand(partyOn);
		SubCommand partyOffSubCom = new SubCommand(partyOff);
		
		remotecontrol.setCommand(0, ovenOn, ovenOff);
		remotecontrol.setCommand(1, mixOn, mixOff);
		remotecontrol.setCommand(2, partyOnSubCom, partyOffSubCom);
	}
	public void mix(BakedGoods bg, int speed) {
		bg.getIngredients();
		mixer.setSpeed(speed);
		mixer.on();
	}
	public void bake(BakedGoods bg, int temp) {
		bg.getTray();
		bg.getTemperature();
		oven.setTemp(temp);
		oven.on();
	}


}
