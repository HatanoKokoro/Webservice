package com.client;


import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class ServiceClient {
	
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/webservice/services/MyWebservice";
		String result = null; 
		try{
			
			RPCServiceClient client = new RPCServiceClient();
			Options options = client.getOptions();
			
			EndpointReference targetEPR = new EndpointReference(url);
			options.setTo(targetEPR);
			
			QName opAddEntry = new QName("http://service.com","getName");
			
			Object[] opAddEntryArgs = new Object[]{"getName"};
			
			Class[] classes = new Class[]{String.class};
			
			result = (String)client.invokeBlocking(opAddEntry, opAddEntryArgs,classes)[0];
			System.out.println(result);
			
			opAddEntry = new QName("http://service.com","print");
			opAddEntryArgs = new Object[]{"print"};
			client.invokeRobust(opAddEntry, opAddEntryArgs);
					
			opAddEntry = new QName("http://service.com","login");
			opAddEntryArgs = new Object[]{"Artoria","123456"};
			result = (String)client.invokeBlocking(opAddEntry, opAddEntryArgs,classes)[0];
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
