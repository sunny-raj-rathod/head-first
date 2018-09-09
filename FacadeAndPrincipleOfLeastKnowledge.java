/*
An example on Facade and Principle of least knowledge
*/

//Principle of least knowledge
/*
Principle of least knowledge - Talk only to your immediate friends.
This principle provides guidelines that:
Take an object, now from any method in that object, we should invoke methods that belong to:
1. The object itself
2. Objects passed in as parameter to method
3. Any object the method creates or instantiates
4. Any components of the object.
*/
public class Car {
  Engine engine;

  public void start(Key key){
    Doors doors = new Doors();
    boolean authorized = key.turns(); //allowed as per 2
    if(authorized){
      engine.start(); //allowed as per 4
      updateDashboardDisplay(); // allowed as per 1
      doors.lock();// allowed as per 3
    }
  }
  void updateDashboardDisplay(){

  }
}

//Facade pattern

// Lets say we want to build Home Theatre System and we have following classes defined, avoiding details here.
public class CdPlayer{

}

public class DvdPlayer{

}

public class Projector{

}

public class TheaterLight{

}

public class Amplifier{

}

public class PopcornPopper{

}

public class Screen{

}

public class Projector{

}
//when we want to watch a movie, we have to follow following steps:
popper.on()
popper.pop()
lights.dim()
screen.down()
projector.on()
projector.setInput(dvd)
amp.on()
amp.setDvd(dvd)
amp.setSound()
dvd.on()
dvd.play(movie)


//so these many operations are to be performed by client to watch a movie on this system.
//Facade just provides a simplification over these interfaces so that client can just interact with the Facade interface and it can handle all the internal calls.

public class HomeTheaterFacade{
  Amplifier amp;
  DvdPlayer dvd;
  PopcornPopper popper;
  TheaterLight light;
  Screen screen;
  Projector projector;

  HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, PopcornPopper popper, TheaterLight light, Screen screen, Projector projector){
    this.amp = amp;
    //..and so on;
  }

  public void playMovie(){
    popper.on()
    popper.pop()
    lights.dim()
    screen.down()
    projector.on()
    projector.setInput(dvd)
    amp.on()
    amp.setDvd(dvd)
    amp.setSound()
    dvd.on()
    dvd.play(movie)
  }

  public void endMovie(){

  }
}
