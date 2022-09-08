public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int medicHealth = 1000;

    public static int[] heroesHealth = {270, 280, 260};

    public static int[] heroesDamage = {20, 15, 25};

    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"};

    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistics();
        round();
        while (!isGameFinished()){
            round();
        }


    }

    public static void printStatistics() {
        System.out.println(" ********* " + roundNumber + " ROUD ***********");
        System.out.println("Boss health: " + bossHealth + " [ " + bossDamage + " ]");

        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: "
                    + heroesHealth[i] + " [" + heroesDamage[i] + "]");

        }
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            heroesHealth[i]= medicHealth-heroesHealth[i];
            heroesHealth[i] = heroesHealth[i] - bossDamage;

        }


    }
    public static void bossHits2(){
        for (int i = 0; i < medicHealth; i++) {
            medicHealth = medicHealth - bossDamage;

        }
    }


    public static void heroesHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0)
                bossHealth = bossHealth - heroesDamage[i];
        }
    }


    public static void round() {
        roundNumber++;
        bossHits();
        heroesHits();
        bossHits2();
        printStatistics();
    }


     public static Boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes Won!");
            return true;

        }for (int i = 0; i < heroesHealth.length; i++) {

            if (heroesHealth[i] <= 0) {
                System.out.println("Boss Won!");
            return true;}
        }
        return false;
    }

}