package br.pdm.klebson.lostboard;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by klebson on 27/08/2016.
 */
public class CalculatorWS {

    public CalculatorWS(){


    }

    public int add(int i, int j)throws IOException, XmlPullParserException{
        SoapObject soap = new SoapObject("http://calculator.me.org/", "add");
        soap.addProperty("i", i); //enviando paramentro para o webservice
        soap.addProperty("j", j);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
        envelope.setOutputSoapObject(soap);

        HttpTransportSE httpTrans = new HttpTransportSE("http://192.168.98.208:8080/CalculatorApp/CalculatorWSService?wsdl");
        httpTrans.call("add", envelope);
        Object resultado = envelope.getResponse();
        return Integer.parseInt(resultado.toString());
    }
    public String adicionar(String nome, String telefone, String placaPerdida, String cidadePlaca, String data, String LocalPerda, String obs)throws IOException, XmlPullParserException{
        SoapObject soap_LB = new SoapObject("http://calculator.me.org/", "adicionar"); //chama o método do webservices
        soap_LB.addProperty("nome", nome);
        soap_LB.addProperty("telefone", telefone);
        soap_LB.addProperty("placaEcontrada", placaPerdida);
        soap_LB.addProperty("cidadePlaca", cidadePlaca);
        soap_LB.addProperty("data", data);
        soap_LB.addProperty("LocalPerda", LocalPerda);
        soap_LB.addProperty("obs", obs);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10); //envelope onde os dados serão enviados para o servlet
        envelope.setOutputSoapObject(soap_LB);

        HttpTransportSE httpTrans = new HttpTransportSE("http://192.168.99.35:8080/CalculatorApp/CalculatorWSService?wsdl");
        httpTrans.call("adicionar", envelope);

        Object resultado_LB = envelope.getResponse();

        return String.valueOf(resultado_LB);

    }


}
