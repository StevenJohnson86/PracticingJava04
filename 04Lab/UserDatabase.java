import java.util.ArrayList;

public final class UserDatabase implements Database<User>{
  private static UserDatabase userDatabase= new UserDatabase();
  private static ArrayList<User> userList;

  private UserDatabase(){
    userList = new ArrayList<User>();
  }

  public static UserDatabase getInstance(){
    return userDatabase;
  }

  public void add(User u){
    userList.add(u);
  }

  public void remove(User u){
    userList.remove(u);
  }

  public boolean search(String un){
    for (User u : userList){
      if(u.username == un){
        return true;
      }
    }
    return false;
  }

  public ArrayList<User> all(){
    return userList;
  }

  public int count(){
    return userList.size();
  }

}
