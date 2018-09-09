/*
Example for Strategy pattern
*/
interface FlyBehaviour{
  void fly();
}

class FlyWithWings implements FlyBehaviour{
  void fly(){
    //chidya ud
  }
}

class NoFly implements FlyBehaviour{
  void fly(){
    //chidya mat ud
  }
}

interface QuackBehaviour{
  void quack();
}

class NormalQuack implements QuackBehaviour {
  void quack(){
    //quack quack
  }
}

class SqueakQuack implements QuackBehaviour {
  void quack(){
    //squeak squeak
  }
}


class Duck {
  FlyBehaviour flyBehaviour;
  QuackBehaviour quackBehaviour;

  void performFly(){
    flyBehaviour.fly()
  }

  void performQuack(){
    quackBehaviour.quack()
  }

  void setFlyBehaviour(FlyBehaviour fb){
    flyBehaviour = fb;
  }

  void setQuackBehaviour(QuackBehaviour qb){
    quackBehaviour = qb;
  }
}

class MallardDuck extends Duck{
  MallardDuck(){
    flyBehaviour = new FlyWithWings();
    quackBehaviour = new NormalQuack();
  }
}

class RubberDuck extends Duck{
  RubberDuck(){
    flyBehaviour = new NoFly();
    quackBehaviour = new SqueakQuack();
  }
}
