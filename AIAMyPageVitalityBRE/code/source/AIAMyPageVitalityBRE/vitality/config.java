package AIAMyPageVitalityBRE.vitality;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSService;
import com.wm.app.b2b.server.InvokeState;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.wm.app.b2b.server.ServerAPI;
import com.wm.app.b2b.server.*;
import java.security.*;
import java.sql.Date;
import java.util.Stack;
import java.io.UnsupportedEncodingException;
import java.math.*;
import java.net.InetAddress;
import java.util.StringTokenizer;
// --- <<IS-END-IMPORTS>> ---

public final class config

{
	// ---( internal utility methods )---

	final static config _instance = new config();

	static config _newInstance() { return new config(); }

	static config _cast(Object o) { return (config)o; }

	// ---( server methods )---




	public static final void getServerPort (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getServerPort)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] field:0:required port
		IDataCursor pipelineCursor = null;
		try {
			pipelineCursor = pipeline.getCursor();
			
			int port= ServerAPI.getCurrentPort();
			
			IDataUtil.put( pipelineCursor, "port", String.valueOf(port));
			
			
		} catch (Exception ex) {
			throw new ServiceException(ex);
		} finally {
			if (pipelineCursor != null)
				pipelineCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}
}

