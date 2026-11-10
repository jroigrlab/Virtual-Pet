public static void main(String[] args) {

    boolean juegoActivo = true;
    int opcion;

    System.out.println("¿Como se va a llamar tu mascota?");
    String nom = teclat.Teclat.llegirString();

    mascota.tipo tipoElegido;
    String eleccion;

    do {
        System.out.println("¿Que animal quieres que sea? (perro/gato)");
        eleccion = teclat.Teclat.llegirString();

        if (eleccion.equalsIgnoreCase("perro")) {
            tipoElegido = mascota.tipo.perro;

        } else if (eleccion.equalsIgnoreCase("gato")) {
            tipoElegido = mascota.tipo.gato;

        } else {
            tipoElegido = null;
            System.out.println("Error: elige perro o gato.");
        }

    } while (tipoElegido == null);

    mascota mascota = new mascota(tipoElegido, nom);

    dummy dummy = null;

        while (juegoActivo) {

            // Mostrar estadísticas antes del menú
            mascota.mostrarEstadisticas();

            System.out.println("\n--- MENU ---");
            System.out.println("1. Sleep");
            System.out.println("2. Play");
            System.out.println("3. Eat");
            System.out.println("4. Clean");
            System.out.println("5. Attack");
            System.out.println("6. Exit");

            opcion = teclat.Teclat.llegirInt();

            if (opcion == 1) {
                mascota.sleep();
                System.out.println("Tu mascota ha dormido.");

            } else if (opcion == 2) {
                mascota.play();
                System.out.println("Tu mascota ha jugado.");

            } else if (opcion == 3) {
                mascota.eat();
                System.out.println("Tu mascota ha comido.");

            } else if (opcion == 4) {
                mascota.clean();
                System.out.println("Tu mascota se ha limpiado.");

            } else if (opcion == 5) {

                if (dummy == null) {
                    dummy = new dummy();

                    System.out.println("¡Se ha creado un dummy!");
                }

                System.out.println("¿Cuantas veces quieres atacar?");
                int veces = teclat.Teclat.llegirInt();

                int contador = 0;

                while (contador < veces && juegoActivo && dummy != null) {

                    mascota.attack(dummy);

                    if (!mascota.comprobarEstado()) {
                        System.out.println("GAME OVER");
                        juegoActivo = false;

                    } else if (!dummy.comprobarEstado()) {
                        System.out.println("¡HAS GANADO!");
                        dummy = null;

                    } else {
                        contador++;
                    }
                }

                System.out.println("\n--- ESTADISTICAS DESPUES DEL ATAQUE ---");
                dummy.mostrarEstadisticas();

            } else if (opcion == 6) {
                juegoActivo = false;

            } else {
                System.out.println("Opcion no valida.");
            }

           
            if (juegoActivo && !mascota.comprobarEstado()) {
                System.out.println("GAME OVER");
                juegoActivo = false;
            }
        }

        System.out.println("Programa finalizado.");
    }
