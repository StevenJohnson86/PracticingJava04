import java.util.ArrayList;

public interface Database<T>{
  public void add(T t);
  public void remove(T t);
  public ArrayList<T> all();
  public int count();
}
