package models;

import java.util.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class Task extends Model{
	
	@Required
	public String label;
	
	@Id
	public long id;
	
	public static Finder<Long,Task> find = new Finder(
		Long.class, Task.class);
		
	
	public static List<Task> all() {
		if (find.all() == null)
		{
		    return new ArrayList<Task>();
		}
		return find.all();
	}
	
	public static void create(Task task) {
		task.save();
	}
	
	public static void delete(long id) {
		find.ref(id).delete();
	}

}
