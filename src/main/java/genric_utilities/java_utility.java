package genric_utilities;

import java.util.Date;

public class java_utility {
	public static String getname() {
		String name= new Date().toString().replace(' ', '_').replace(':', '_');
		return name;
	}
}
