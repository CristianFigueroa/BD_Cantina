import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    ejecutar();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }

        }
    }

    private static void consultar() {
        BaseDeDatos baseDatos = new BaseDeDatos().conectar();
        ResultSet resultados = baseDatos.consultar("SELECT * FROM TEST");
        if (resultados != null) {
            try {
                System.out.println("IDENTIFICADOR       DESCRIPCION");
                System.out.println("--------------------------------");
                while (resultados.next()) {
                    System.out.println("" + resultados.getBigDecimal("IDENTIFICADOR") + "       " + resultados.getString("DESCRIPCION"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void ejecutar() {
        BaseDeDatos baseDatos = new BaseDeDatos().conectar();
        if (baseDatos.ejecutar("INSERT INTO TEST(IDENTIFICADOR,DESCRIPCION) VALUES(3,'TRES')")) {
            System.out.println("Ejecución correcta!");
        } else {
            System.out.println("Ocurrió un problema al ejecutar!");
        }
    }

}
