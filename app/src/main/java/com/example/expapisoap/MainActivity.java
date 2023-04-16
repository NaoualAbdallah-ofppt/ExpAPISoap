package com.example.expapisoap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new asynchTask().execute();
    }
private class   asynchTask extends AsyncTask<Void,Void, String> {


     String SOAP_URL = "http://www.dneonline.com/calculator.asmx?wsdl";
    String methodName = "Add";
    String nameSpace="http://tempuri.org/";
    String soapAction="http://tempuri.org/Add";


    @Override
    protected String doInBackground(Void... voids) {
        String result="";
    try {
        SoapObject request = new SoapObject(nameSpace, methodName);
         request.addProperty("intA", 5);
         request.addProperty("intB", 10);
        SoapSerializationEnvelope enveloppe = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        enveloppe.dotNet = true;
        enveloppe.setOutputSoapObject(request);
        HttpTransportSE transport= new HttpTransportSE(SOAP_URL,30000);
        transport.call(soapAction, enveloppe);
        SoapObject response = (SoapObject) enveloppe.bodyIn;
        SoapPrimitive resultP=(SoapPrimitive)response.getProperty("AddResult");

                Log.i("aa",response.toString());



        Log.i("aa","ok2");




       result=resultP.toString();

        /*    if (enveloppe.getResponse() != null) {
                aa = enveloppe.getResponse().toString();
            }


         */
        } catch (Exception e) {

        }

            return result;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("aa","result:"+result);
    }

}

}
