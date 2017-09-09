public class ErrorsAndGenerics{
  public static void main(String[] args){

    //instatiating 3 users (the forth will throw UserException)
    System.out.println("Instantiating 4 Users, but one will throw UserException due to invalid email: ");
    User bob = createUser("Bob", 50, "Bob@gmail.com", "numba1Bob");
    User bobby = createUser("Bobby", 49, "Bobby@gmail.com", "numba2Bob");
    User robert3 = createUser("Robert", 48, "numba3Bob", "Robert@gmail.com");
    User robert = createUser("Robert", 48, "Robert@gmail.com", "numba3Bob");

    //checking to see if user was initialized properly
    if(bob != null){

      //Bob logging in with wrong username
      System.out.println("\nBob tries to login with wrong username: ");
      try{
        bob.login("numba4Bob");
      } catch(UserException e){
        System.out.println(e + ": " + e.description);
      }

      //Bob logging in twice
      System.out.println("\nBob tries to login twice: ");
      try{
        bob.login("numba1Bob");
        bob.login("numba1Bob");
      } catch(UserException e){
        System.out.println(e + ": " + e.description);
      }

      //Bob logging out when already logged out
      System.out.println("\nBob tries to logout twice: ");
      try{
        bob.logout();
        bob.logout();
      } catch(UserException e){
        System.out.println(e + ": " + e.description);
      }

    }

    //Try to add an extra bob, then remove him.
    System.out.println("\nUsers are automatically added to UserDatabase when instantiated.");
    System.out.println("Here is the initial count of users: " + UserDatabase.getInstance().count());

    System.out.println("\nWe try to create a user with bobs username: ");
    User bob4 = createUser("Bob", 65, "bob4@gmail.com", "numba1Bob");

    UserDatabase.getInstance().remove(bob);
    System.out.println("\nWe're done with Bob. UserList size after removing bob: " + UserDatabase.getInstance().count());
    System.out.println("UserList contents (calling all() method):\n" + UserDatabase.getInstance().all());

  }

  public static User createUser(String name, int age, String email, String username){
    User a = null;
    try{
      a = new User(name, age, email, username);
    } catch(UserException ue){
      System.out.println(ue + ": " + ue.description);
    } catch(Exception e){
      System.out.println(e);
    }
    return a;
  }

}
