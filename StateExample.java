/*
An example for State Pattern
Lets say we have a gumball machine which follows following state machine:
NoQuarter --- (insert quarter) ------- HasQuarter -------(turn crank)-------GumballSold----(Dispense Gumball)----(numGumballs > 0)----no---OutOfGumballs
    |____________(Ejects quarter)_____________|                                                                           |yes
    |_____________________________________________________________________________________________________________________|
*/

//Note that NoQuarter, QuarterInserted, GumballSold, OutOfGumballs are the states
//and InsertQuarter, TurnCrank are actions
//One simple way to implement this state machine is to have conditional statements corresponding to each state in each action
//but this implementation is not extensible and maintainable.

//State pattern provides an easy way to handle this in maintainable way.

public interface State{
  void InsertQuarter();
  void EjectQuarter();
  void TurnCrank();
  void DispenseGumball();
}

//Each state implements the operations in their own way,i.e.has its own behaviour.
//Hence depending on the state of object(GumballMachine here), the behaviour of the object differs.
public class NoQuarter implements State{
  GumballMachine gumballMachine;

  NoQuarter(GumballMachine gumballMachine){
    this.gumballMachine = gumballMachine;
  }

  void insertQuarter(){}
  void ejectQuarter(){}
  void turnCrank(){}
  void dispenseGumball(){}
}

public class HasQuarter implements State{
  void insertQuarter(){}
  void ejectQuarter(){}
  void turnCrank(){}
  void dispenseGumball(){}
}

public class Sold implements State{
  void insertQuarter(){}
  void ejectQuarter(){}
  void turnCrank(){}
  void dispenseGumball(){}
}

public class SoldOut implements State{
  void insertQuarter(){}
  void ejectQuarter(){}
  void turnCrank(){}
  void dispenseGumball(){}
}

//Object or also known as context in state pattern, just calls the state, and state will validates which state the object can move to
//For example, here based on count of gumballs, Sold state's dispenseGumball method can decide whether to move the GumballMachine to NoQuarter state or SoldOut state.
class GumballMachine{
  State noQuarter;
  State sold;
  State hasQuarter;
  State soldOut;

  int count = 0;
  State currentState = soldOut;

  GumballMachine(int gumballs){
    count = gumballs;
    noQuarter = new NoQuarter();
    hasQuarter = new HasQuarter();
    sold = new Sold();
    soldOut = new SoldOut();
    if(count > 0)
      currentState = noQuarter;
  }

  void setState(State state){
    currentState = state;
  }

  int getCount(){}

  void insertQuarter(){
    state.insertQuarter();
  }
  void ejectQuarter(){
    state.ejectQuarter();
  }
  void turnCrank(){
    state.turnCrank();
  }
  void releaseGumball(){
    if(count > 0){
      count--;
    }
  }
}
