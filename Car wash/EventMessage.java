// roei lahav 315808469
// matam maman 21622149
package Exe2;

import java.util.EventObject;


public class EventMessage extends EventObject {

	private static final long serialVersionUID = 1L;
	private String message;

	public EventMessage(Object source, String msg)
	{
		super(source);
		this.message = msg;
	}
	
	public String getMessage() {
		return this.message;
		
	}

}
