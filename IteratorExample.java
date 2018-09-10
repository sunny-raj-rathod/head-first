/*
An example for iterator pattern.
Iterator pattern simply provides an interface to sequentially access object without exposing its underlying implementation
*/

//2 diners have different implementations of Menu items.

public class MenuItem{

}

public class DinerA{
  MenuItem[] menuItems;
  public MenuItem[] getMenuItems();
}

public class DinerB{
  ArrayList menuItems;
  public ArrayList getMenuItems();
}

public class Waitress{
  DinerA a;
  DinerB b;

  public void getAllMenus(){
    //we need to get menu from both the diners and then iterate over them individually
    //this time of design is not extensible since if one more diner is added more code needs to be added to handle implementation of that diner separately
  }
}

//A better approach would be to create an iterator interface to streamline the interface to iterate over the objects of different implementations.

public interface Iterator{
  boolean hasNext();
  Object next();
}

class DinerAIterator implements Iterator{
  DinerAIterator(MenuItem[] menuItems){

  }

  //specific implementation
  boolean hasNext(){

  }

  Object next(){

  }
}

class DinerBIterator implements Iterator{
  DinerBIterator(ArrayList menuItems){

  }

  //specific implementation
  boolean hasNext(){

  }

  Object next(){

  }
}

public class DinerA{
  MenuItem[] menuItems;
  public MenuItem[] getMenuItems();

  public Iterator createIterator(){
    return new DinerAIterator(menuItems);
  }
}

public class DinerB{
  ArrayList menuItems;
  public ArrayList getMenuItems();

  public Iterator createIterator(){
    return new DinerBIterator(menuItems);
  }
}

public class Waitress{
  DinerA a;
  DinerB b;

  public void getAllMenus(){
    print(a);
    print(b);
  }

  public void print(Iterator iterator){
      while(iterator.hasNext()){
        syso(iterator.next())
      }
  }
}
