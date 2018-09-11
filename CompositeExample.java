/*
An example for Composite pattern
It allows objects to be composed into tree structure representing parent-child relationship.
In the example, we define a MenuComponent interface that can be either a submenu or a menu item based on the methods implemented by the subclass.
This opens up some design tradeoff, since the subclass can implement any method they want and not adhere to principle with which interface has been created.
*/

public abstract class MenuComponent{
  //these  methods are supposed to be implemented by MenuItem
  string getName(){}
  string getDescription(){}
  string getPrice(){}

  //following methods can be implemented by sub menu
  void add(MenuComponent menuComponent){}
  void remove(MenuComponent menuComponent){}
  MenuComponent getChild(i){}
}

public class MenuItem extends MenuComponent{
  string name, description, price;

  string getName(){}
  string getDescription(){}
  string getPrice(){}
}

public class Menu extends MenuComponent{
  //hierarchy defined due to this list of children
  //A menu can have either a MenuItem or a nested Menu
  ArrayList menuComponents;

  void add(MenuComponent menuComponent){}
  void remove(MenuComponent menuComponent){}
  MenuComponent getChild(i){}
}
