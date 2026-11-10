import java.util.Random;

public class mascota {

    //Mascota
    public String nom;
    public tipo tipoAnimal;
    public enum tipo{perro, gato};

    //Atributos mascota
    public int energia;
    public int higiene;
    public int peso;
    public int mood;



    public mascota(tipo tipo, String nom){
        Random random = new Random();
        this.nom = nom;
        this.tipoAnimal = tipo;
        this.energia = random.nextInt(21)+40;
        this.higiene = random.nextInt(21)+40;
        this.peso = random.nextInt(21)+40;
        this.mood = random.nextInt(21)+40;
    }

    public void mostrarAnimal() {
        System.out.println("Has elegido un " + tipoAnimal);
    }

    //Clases Menu
    public void sleep(){
        if (tipoAnimal == tipo.perro){
            this.energia=energia + 25;
            this.mood=mood+ 10;
        } else {
            this.energia=energia + 20;
            this.mood=mood + 10;
        }
    }

    public void play(){
        this.energia=energia - 20;
        this.peso=peso - 10;
        this.mood=mood + 20;
    }

    public void eat(){
        this.energia=energia + 10;
        this.peso=peso + 10;
        this.higiene=higiene - 15;
    }

    public void clean(){
        if (tipoAnimal == tipo.perro){
            this.energia=energia - 10;
            this.mood=mood - 15;
            this.higiene=higiene + 25;
        } else{
            this.higiene=higiene + 25;
            this.mood=mood + 10;
            this.energia=energia - 5;
        }
    }

    public void attack(dummy dummy){
    this.energia -= 3;
    this.higiene -= 3;
    this.mood -= 3;

    dummy.energia -=3;
    dummy.higiene -=3;
    dummy.mood -=3;
    }

    public void exit(){

    }

    public boolean comprobarEstado(){
        return energia > 0 && energia <=100 && higiene > 0 && higiene <=100 && mood > 0 && mood <=100 && peso > 0 && peso <=100;
    }
    public void mostrarEstadisticas() {
        System.out.println("\n--- ESTADISTICAS DE " + nom + " ---");
        System.out.println("Tipo: " + tipoAnimal);
        System.out.println("Energia: " + energia);
        System.out.println("Higiene: " + higiene);
        System.out.println("Peso: " + peso);
        System.out.println("Mood: " + mood);
        System.out.println("------------------------------");
    }
}
