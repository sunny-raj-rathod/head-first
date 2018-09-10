/*
Observer Pattern
can be a pull or push - depending on whether notifyObservers is sending Observable data to Observer or Observer is getting the data based on received notification
*/

class Observable{
  void addObserver(Observer o);
  void removeObserver(Observer o);
  void notifyObservers();
}

class WeatherData extends Observable{
  //attributes
  private int prop1, prop2, prop3;
  //public getters for properties
  public int getProp1();
  public int getProp2();
  public int getProp3();

  private void propChanged(){
    notifyObservers();
  }
}

interface Observer{
  void update(Observable o, Object obj);
}

interface Display{
  void display();
}

class O1 implements Observer, implements Display{
  Observable o;
  int p1;

  O1(Observable ob){
    o = ob;
    o.addObserver(this);
  }

  void update(Observable o){
    p1 = o.getProp1();
    display();
  }
}

class O2 implements Observer, implements Display{
  Observable o;
  int p2;
  void update(Observable o){
    p2 = o.getProp2();
    display();
  }
}
