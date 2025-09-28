import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = screenSize.width;
        int alto = screenSize.height;

        //Realiza aquí el bucle para abrir las ventanas que quieras (recomiendo for)
        int numeroDeVentanas = 20; // ajusta si quieres más o menos
        for (int i = 0; i < numeroDeVentanas; i++) {
            trastada(ancho, alto, i);
            try { Thread.sleep(120); } catch (InterruptedException ignored) {}
        }

        //Aquí deberás hacer otro bucle para que el usuario acierte el número (recomiendo do-while)
        Random rnd = new Random();
        int secreto = 1 + rnd.nextInt(100);
        Scanner sc = new Scanner(System.in);
        int intento;
        int intentos = 0;

        System.out.println("⚠️  Te has 'infectado' (simulación).");
        System.out.println("🔐 Para volver a la normalidad, debes adivinar un número del 1 al 100. ¡Buena suerte!");

        do {
            System.out.print("Introduce tu número: ");
            while (!sc.hasNextInt()) {
                System.out.print("Introduce un número válido (1-100): ");
                sc.next(); // descarta entrada no numérica
            }
            intento = sc.nextInt();
            intentos++;

            if (intento < 1 || intento > 100) {
                System.out.println("Debe estar entre 1 y 100.");
            } else if (intento < secreto) {
                System.out.println("Demasiado bajo. Prueba un número más alto ⬆️");
            } else if (intento > secreto) {
                System.out.println("Demasiado alto. Prueba un número más bajo ⬇️");
            }
        } while (intento != secreto);

        System.out.println("Enhorabuena 🥳 ¡Has acertado! (El número es " + secreto + ").");
        System.out.println("👉 Lo lograste en " + intentos + " intento(s). 'Desinfectando...⌛' Se han cerrado todas las pestañas!");

        sc.close();

        //Para cerrar todas las ventanas y finalizar el programa descomenta la siguiente linea
        System.exit(0);
    }

    public static void trastada(int ancho, int alto, int i){
        JFrame frame = new JFrame("¡Ups!");
        frame.setSize(200, 100);

        // Colocar en posición aleatoria dentro de los límites
        int x = (int) (Math.random() * (ancho - frame.getWidth()));
        int y = (int) (Math.random() * (alto - frame.getHeight()));
        frame.setLocation(x, y);

        if(i % 2 == 0){
            frame.add(new JLabel("Tu PC tiene sueño... 😴", SwingConstants.CENTER));
        } else {
            frame.add(new JLabel("Tu PC está pensando... 🤔", SwingConstants.CENTER));
        }

        frame.setVisible(true);
    }
}
