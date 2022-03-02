package pckgMain;

public class christmasArt {

    public static int barva = 1;
    public static int N = 1;
    public static int N1 = 1;
    public static int barva1 = 1;

    /**
     * Metoda pro vypsání ryby v požadovaném tvaru
     */
    public static void Fish() {

        String spaces1 = "";
        String stars1 = "x", stars2 = "";
        System.out.println("Zadejte velikost kapra:");
        N = UI.sc.nextInt();
        System.out.println("Zadejte dvě barvy: 1.cerna/2.cervena/3.zelena/4.modra/5.zluta/6.fialova/7.azurova/8.bila");
        barva = UI.sc.nextInt();
        barva1 = UI.sc.nextInt();

        for (int i = 0; i < N; i++) {
            spaces1 += " ";
        }

        for (int i = 0; i < 2 * N + 1; i++) {

            if (i < N) {
                System.out.print(color(barva) + spaces1 + stars1 + spaces1 + spaces1);
                System.out.println(color2(barva1) + stars2);
                spaces1 = spaces1.substring(0, spaces1.length() - 1);
                stars1 += "xx";
                stars2 += "(";
            }

            if (i == N) {
                System.out.print(color(barva) + spaces1 + stars1 + spaces1 + spaces1);
                System.out.println(color2(barva1) + stars2);
            }

            if (i > N) {
                spaces1 += " ";
                stars1 = stars1.substring(0, stars1.length() - 1);
                stars1 = stars1.substring(0, stars1.length() - 1);
                stars2 = stars2.substring(0, stars2.length() - 1);
                System.out.print(color(barva) + spaces1 + stars1 + spaces1 + spaces1);
                System.out.println(color2(barva1) + stars2);
            }

        }
        System.out.print("\u001B[0m" + "\n" + "!VÁNOČNÍ BAREVNÝ KAPR!" + "\n\n\n");
    }

    /**
     * Metoda pro zvolení 1. barvy
     * 
     * @param N
     * @return barva(String)
     */
    private static String color(int N) {

        String barva;
        switch (N) {
            case 1:
                barva = "\u001B[30m";
                break;
            case 2:
                barva = "\u001B[31m";
                break;
            case 3:
                barva = "\u001B[32m";
                break;
            case 4:
                barva = "\u001B[34m";
                break;
            case 5:
                barva = "\u001B[33m";
                break;
            case 6:
                barva = "\u001B[35m";
                break;
            case 7:
                barva = "\u001B[36m";
                break;
            case 8:
                barva = "\u001B[37m";
                break;
            default:
                barva = "\u001B[0m";
                break;
        }
        return barva;
    }

    /**
     * Metoda pro zvolení 2. barvy
     * 
     * @param N1
     * @return barva(String)
     */
    private static String color2(int N1) {

        String barva;
        switch (N1) {
            case 1:
                barva = "\u001B[30m";
                break;
            case 2:
                barva = "\u001B[31m";
                break;
            case 3:
                barva = "\u001B[32m";
                break;
            case 4:
                barva = "\u001B[34m";
                break;
            case 5:
                barva = "\u001B[33m";
                break;
            case 6:
                barva = "\u001B[35m";
                break;
            case 7:
                barva = "\u001B[36m";
                break;
            case 8:
                barva = "\u001B[37m";
                break;
            default:
                barva = "\u001B[0m";
                break;
        }
        return barva;
    }

    /*
     * public static void main(String[] args) {
     * Fish();
     * }
     */

}
