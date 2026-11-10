public class dummy {
    public int energia;
    public int higiene;
    public int mood;
    public int peso;

    public dummy(){
        this.energia = 100;
        this.higiene = 100;
        this.peso = 100;
        this.mood = 100;
    }
    public boolean comprobarEstado(){
        return energia > 0 && higiene >0 && mood > 0;
    }

    public void mostrarEstadisticas() {
        System.out.println("--- ESTADISTICAS DEL DUMMY ---");
        System.out.println("Energia: " + energia);
        System.out.println("Higiene: " + higiene);
        System.out.println("Peso: " + peso);
        System.out.println("Mood: " + mood);
    }

}

