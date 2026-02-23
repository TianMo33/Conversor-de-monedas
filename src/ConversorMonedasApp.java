import com.google.gson.*;
import java.io.IOException;
import java.util.Scanner;

public class ConversorMonedasApp {


    public static void main(String[] args) throws IOException, InterruptedException {
        Conversor conversor = new Conversor();
        while(true){

            System.out.println("/*************************************************/");
            System.out.println("Conversor de Monedas. Elija un número:");
            System.out.println("1. Convesión de dolar a peso mexicano");
            System.out.println("2. Conversión de dolar a peso argentino");
            System.out.println("3. Salir");
            System.out.println("***************************************************/ ");
            Scanner lectura = new Scanner(System.in);
            var opcion = lectura.nextLine();
            if(opcion.equals("3")){break;}
            System.out.println("/*************************************************/");
            System.out.println("Escribe la cantidad a convertir en números:");
            double cantidad = Double.parseDouble(lectura.nextLine());
            double resultado = conversor.obtenerConversion(opcion, cantidad);
            if(opcion.equals("1")){
                System.out.println("Resultado: " + resultado+" dolar a pesos mexicanos");
            }
            if(opcion.equals("2")){
                System.out.println("Resultado: " + resultado+" dolar a peso argentino");
            }
        }
    }
}



