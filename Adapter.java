/*
Example for Adapter Pattern
Client-------request ------Adapter------translated request----Adaptee
Simple example of using a turkey as a duck
*/

public interface Duck{
  void quack();
  void fly();
}

public class MallardDuck implements Duck{
  void quack(){}
  void fly(){}
}

public interface Turkey{
  void gobble();
  void fly();
}

public class WildTurkey implements Turkey{
  void gobble(){}
  void fly(){}
}

//What if we want to use Turkey as Duck
//we create an Adapter

public class TurkeyAdapter implements duck{
  Turkey turkey;
  TurkeyAdapter(Turkey turkey){
    this.turkey = turkey;
  }
  void quack(){
    turkey.gobble();
  }
  void fly(){
  // some specific implementation
  }
}
