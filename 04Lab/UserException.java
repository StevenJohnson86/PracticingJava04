public class UserException extends Exception{
  private static final long serialVersionUID = 13L;
  String description;

  public UserException(String s){
    this.description = s;
  }
}
