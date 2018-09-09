/*
Example for Singleton Pattern
2 important things here:
volatile - for making access thread safe while object is being initialized
Double-checked locking -
Problem: Method getInstance can be called by 2 threads simultaneously, which will lead to object creation 2 times.
To avoid this, we can make getInstance synchronized, but this would be too expensive for the application
The solution for this, is either early instantiation of uniqueInstance
public volatile static Singleton uniqueInstance = new Singleton();
or
double-checked locking - so that we don't put synchronized on method level, rather only when uniqueInstance is not initialized.
*/

public class Singleton{
  public volatile static Singleton uniqueInstance;

  private Singleton(){
  }

  public static Singleton getInstance(){
    if(uniqueInstance == null){
      synchronized (Singleton.class){
        if(uniqueInstance == null){
          uniqueInstance = new Singleton();
        }
      }
    }
    return uniqueInstance;
  }
}
