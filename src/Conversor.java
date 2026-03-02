import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Conversor {
    String direccion_dolarapeso = "https://v6.exchangerate-api.com/v6/API_KEY/pair/USD/MXN";
    String direccion_dolaraarg = "https://v6.exchangerate-api.com/v6/API_KEY/pair/USD/ARS";

    public static double obtenerTasa(String direccion) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //Conversión a JSON
        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objectRoot = elemento.getAsJsonObject();
        //Accediendo a JsonObject
        double tasa = objectRoot.get("conversion_rate").getAsDouble();
        return tasa;
    }
    public double obtenerConversion(String opcion, double cantidad) throws IOException, InterruptedException {
        double valor = 0;
        if (opcion.equals("1")) {
            var dolarapeso= obtenerTasa(direccion_dolarapeso);
            valor= cantidad*dolarapeso;
        }
        if (opcion.equals("2")) {
            var dolaraarg=obtenerTasa(direccion_dolaraarg);
            valor=cantidad*dolaraarg;
        }
        return valor;
    }
}

