public class User extends Person{
  String email;
  String username;
  boolean loggedIn = false;

  public User(String name, int age, String email, String username) throws UserException{
    super(name, age);

    if(!email.contains("@")) throw new UserException("Enter a valid email and try again.");
    if(UserDatabase.getInstance().search(username)) throw new UserException("Username already exists. Try again.");
    this.email = email;
    this.username = username;
    UserDatabase.getInstance().add(this);
  }

  public void login(String un) throws UserException{
    if(this.username != un) throw new UserException("Login failed, wrong username.");
    if(this.loggedIn == true) throw new UserException("User is already logged in.");

    this.loggedIn = true;
    System.out.println(username + " logged in successfully!");
  }

  public void logout() throws UserException{
    if(this.loggedIn == false) throw new UserException("Logout failed. User not logged in.");

    this.loggedIn = false;
    System.out.println(username + " now logged out.");
  }
}
