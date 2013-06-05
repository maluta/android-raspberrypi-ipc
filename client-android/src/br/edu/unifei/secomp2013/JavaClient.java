package br.edu.unifei.secomp2013;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Generated code
import tutorial.*;
import shared.*;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

import android.util.Log;

public class JavaClient {
	private static final String TAG = null;
	private static int quotient;

	public JavaClient() {

		try {
			TTransport transport;
			transport = new TSocket("192.168.1.7", 9090);
			transport.open();

			TProtocol protocol = new  TBinaryProtocol(transport);
			Calculator.Client client = new Calculator.Client(protocol);

			perform(client);
			

			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		} 
	}

	public static void setColor(Calculator.Client client) throws TException {
		
	}
		
	private static void perform(Calculator.Client client) throws TException
	{
		client.ping();
		Log.e(TAG,"ping()");

		int sum = client.add(1,1);
		Log.e(TAG,"1+1=" + sum);

		Work work = new Work();

		work.op = Operation.DIVIDE;
		work.num1 = 1;
		work.num2 = 0;
		try {
			setQuotient(client.calculate(1, work));
			Log.e(TAG,"Whoa we can divide by 0");
		} catch (InvalidOperation io) {
			Log.e(TAG,"Invalid operation: " + io.why);
		}

		work.op = Operation.SUBTRACT;
		work.num1 = 15;
		work.num2 = 10;
		try {
			int diff = client.calculate(1, work);
			Log.e(TAG,"15-10=" + diff);
		} catch (InvalidOperation io) {
			Log.e(TAG,"Invalid operation: " + io.why);
		}

		SharedStruct log = client.getStruct(1);
		Log.e(TAG,"Check log: " + log.value);
	}
	
	

	public static int getQuotient() {
		return quotient;
	}

	public static void setQuotient(int quotient) {
		JavaClient.quotient = quotient;
	}
}
