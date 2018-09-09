/*
Contains example on Command pattern
Important terminologies:
Client ---- createCommandObject() ----Command ------execute actions on---Receiver------
 |                                      |
 |                                      |
 |                                      |
 Invoker---------------------------------
Command
Receiver
Invoker
*/


public interface Command{
  public void execute();
}

//Receiver
public class Light{
  public void on();
  public void off();
}

//Command
public class LightOnCommand implements Command{
  //this is an instance of receiver
  Light light;
  LightOnCommand(Light light){
    this.light = light;
  }

  //controls actions on receiver
  public void execute(){
    light.on();
  }
}

//Invoker
public class SimpleRemoteControl{
  Command slot;

  //sets command object passed by client
  public void setCommand(Command command){
    this.slot = command;
  }

  // invokes command's execute method
  public void buttonWasPressed(){
    slot.execute();
  }
}

//Client code
SimpleRemoteControl remote = new SimpleRemoteControl();
Light light = new Light();
Command light = new LightOnCommand(light);
remote.setCommand(light);
remote.buttonWasPressed();
