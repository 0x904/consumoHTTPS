package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;


public class ServicioApi
{
	public static String obtenerDatos()
	{
		int codigo;
		BufferedReader in;
		StringBuilder sb = new StringBuilder();
		String linea;

		try
		{
			URL url = new URL("https://restcountries.com/v3.1/all?fields=name,capital,region,population");
			HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();

			conexion.setRequestMethod("GET");
			conexion.setRequestProperty("User-Agent", "Java-HTTPS-Client");

			codigo = conexion.getResponseCode();

			System.out.println(codigo);

			if (codigo==200)
			{
				in = new BufferedReader(
						new InputStreamReader(conexion.getInputStream()));

		        while ((linea = in.readLine()) != null) sb.append(linea);

				in.close();
				
				JSONObject json = new JSONObject(sb.toString());
				// ... pa seguir puhhhhhh
			}
			
			conexion.disconnect();

		}
		catch(MalformedInputException e)
		{
			System.out.println("malformao");
		}
		catch(IOException e)
		{
			System.out.println("io");
		}

		return "";
	}
}
