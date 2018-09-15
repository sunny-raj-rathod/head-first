/*
An example for MVC pattern
DJ application
*/

public interface BeatObserver{
  void updateBeat();
}

public interface ModelInterface{
  public void init();
  public void on();
  public void off();
  public void registerObserver(BeatObserver o);
  public void removeObserver(BeatObserver o);
}

public class BeatModel implements ModelInterface{
  ArrayList beatObservers;

  //method implementations
  public void init(){}
  public void on(){}
  public void off(){}
  public void registerObserver(BeatObserver o){}
  public void removeObserver(BeatObserver o){}
}

public class View implements BeatObserver{
  ModelInterface model;
  ControllerInterface controller;
  //rest of UI elements

  View(ControllerInterface controllerInterface, ModelInterface modelInterface){

  }

  void updateBeat(){

  }
}

public interface ControllerInterface{
  void start();
  void stop();
  void up();
  void down();
  void set(int bpm);
}

public class BeatController implements ControllerInterface{
  View view;
  ModelInterface model;

  BeatController(ModelInterface modelInterface){
    this.model = modelInterface;
    //see this association
    this.view = new View(this, model)
  }
}


//client
ModelInterface model = new BeatModel();
ControllerInterface controller = new BeatController(model);
