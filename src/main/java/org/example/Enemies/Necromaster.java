package org.example.Enemies;

public class Necromaster extends Enemy {
    public Necromaster(String name,int health,int attackMin,int attackMax) {
        super(name,health,attackMin,attackMax);
    }
    public void icon() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠘⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠙⠛⣿⣿⣿⣧⠀⠀⠀⠻⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⠟⠛⠛⠻⣿⣿⣿⡟⢁⠤⠄⠀⠀⢻⣿⣿⠂⠀⠀⠠⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⠋⠀⣄⡀⠐⣦⠈⠙⠿⠇⠞⢆⣀⡼⠀⠊⠉⠉⠄⠐⢨⣴⣿⣿⣿⣿⣿\n" +
                "⣿⣿⡇⠀⠛⡀⠀⠀⠀⠀⠀⢀⣤⣼⡄⠸⠁⠀⠀⢰⣤⠀⠀⡈⢿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣧⡀⠒⢷⣶⠀⠀⠀⢀⣼⣿⣿⣿⣆⣁⣀⡀⠸⣿⠀⠘⡅⢸⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣤⡄⠈⠁⣀⣠⣿⣿⣿⣿⡟⢡⠇⠀⠀⡞⢻⡆⢀⣿⣾⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⡿⠋⠁⠀⠀⠈⠀⠈⠿⢸⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠀⠀⠀⠀⠀⠀⠀⠀⡀⢸⣿⣿⣿⡟⢻⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡉⠹⠀⠀⠀⠀⠀⠀⠀⠀⣸⡇⢸⠈⣿⠿⢉⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡟⢻⣿⣿⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⠘⣠⣿⠀⣾⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡇⠺⣿⡟⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⢸⣿⣿⣀⠘⢿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠃⠀⠛⠃⠀⢠⡀⠤⠖⠢⣤⡤⠀⡤⡄⡀⢸⠛⠛⣿⠀⢸⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡀⠠⠴⣿⣧⣀⣀⠀⠀⠀⠀⠀⠀⠃⠈⠄⠸⠷⠦⠀⢀⣾⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣷⣦⣄⣀⠀⠉⠉⠀⠛⠛⠛⠓⠂⠀⠉⠀⠁⣀⣠⣶⣿⣿⣿⣿");
    }
}