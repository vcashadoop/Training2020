package AIAMyPageVitalityBRE.services;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
// --- <<IS-END-IMPORTS>> ---

public final class atomic

{
	// ---( internal utility methods )---

	final static atomic _instance = new atomic();

	static atomic _newInstance() { return new atomic(); }

	static atomic _cast(Object o) { return (atomic)o; }

	// ---( server methods )---




	public static final void getPipelineData (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getPipelineData)>> ---
		// @sigtype java 3.5
		// [o] record:0:required reqBody
		
		IData reqBody = IDataFactory.create();
		IDataCursor pc = pipeline.getCursor();
		IDataCursor dc = reqBody.getCursor();
		 
		if (pc.first())
		 do
		 { dc.insertAfter( pc.getKey(), pc.getValue());
		 }
		 while (pc.delete());
		 
		pc.insertAfter( "reqBody", reqBody);
		pc.destroy();
		dc.destroy();
			
		// --- <<IS-END>> ---

                
	}
}

