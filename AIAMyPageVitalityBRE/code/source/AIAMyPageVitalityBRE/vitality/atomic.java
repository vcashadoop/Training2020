package AIAMyPageVitalityBRE.vitality;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import com.wm.app.b2b.server.ServiceThread;
// --- <<IS-END-IMPORTS>> ---

public final class atomic

{
	// ---( internal utility methods )---

	final static atomic _instance = new atomic();

	static atomic _newInstance() { return new atomic(); }

	static atomic _cast(Object o) { return (atomic)o; }

	// ---( server methods )---




	public static final void invokeBackend (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(invokeBackend)>> ---
		// @sigtype java 3.5
		// [i] record:0:required input
		// [i] field:0:required serviceName
		// [o] object:0:required runningService
		IDataCursor idcPipeline = pipeline.getCursor();
		String serviceName = null;
		IData input = null;
		
		
		//Some services need input parameters
		if (idcPipeline.first("input"))
		{
		            //get the input object out of the pipeline                                    
		            input = (IData)idcPipeline.getValue();
		
		}
		//if it is not in the pipeline, then get the value from the pipeline or throw error
		else
		{
		            //input = pipeline;
		      throw new IllegalArgumentException("Error invoking backend service: input IData is null!");
		}
		
		
		//Delete the runningService object from the pipeline if it exists 
		if(idcPipeline.first("runningService"))
		            idcPipeline.delete();
		
		
		ServiceThread st = null ;
		
		
		//service
		if (idcPipeline.first("serviceName"))
		{
		                                          
		      serviceName = (String)idcPipeline.getValue();   
		
		}
		
		else
		{
		      throw new IllegalArgumentException("Error invoking backend service: service name is null!");
		}
		
		
		try
		{
		      NSName nsName = NSName.create(serviceName);
		      st = Service.doThreadInvoke(nsName, IDataUtil.deepClone(input));
		      
		//    Service.doThreadInvoke(svc, input, time)
		      		    
		
		}
		//Catch any error's in creating a new service thread
		catch (Exception e) 
		{
			 throw new IllegalArgumentException("Error invoking backend service: "+e.toString());
		//    util.Log.log("Error executing sample.threads.utils:newServiceThread:" + e.toString(), "sample.threads");
			 
		
		}
		
		            
		
		//insert the successFlag into the pipeline
		//idcPipeline.insertAfter("successFlag", successFlag);  
		
		// pipeline
		idcPipeline.insertAfter("runningService", st);
		idcPipeline.destroy();
		
		
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void receiveBackend (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(receiveBackend)>> ---
		// @sigtype java 3.5
		// [i] object:0:required runningService
		// [o] record:0:required output
		IDataCursor idcPipeline = pipeline.getCursor();
		ServiceThread st = null;
		
		//Output Variables 
		IData output;
		
		// Check to see if the runningService object is in the pipeline
		if (idcPipeline.first("runningService"))
		{
		            //get the filename out of the pipeline                                  
		            st = (ServiceThread)idcPipeline.getValue();     
		
		}
		//if it is not in the pipeline, then handle the error
		
		try
		{
		      output = st.getData();
		      idcPipeline.insertAfter("output", output);      
		
		}
		catch ( Exception e ) 
		{
		      throw new IllegalArgumentException(e.toString());
		}
		
		 
			
		// --- <<IS-END>> ---

                
	}
}

