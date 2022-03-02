package pckgMain;

public class calculations {

    public static int P1;
    public static int P2;
    public static int[] koef1;
    public static int[] koef2;
    public static int[] soucetPole;

    /**
     * Metoda pro zadani stupnu polynomu a koeficientu a nasledne zavolani metody
     * pro vystup
     */
    public static void start() {

        boolean isNotAcceptable = false;
        try {
            do {

                System.out.println("Stupen prvniho polynomu  (cele kladne cislo): ");

                if ((P1 = UI.sc.nextInt()) < 0) {
                    isNotAcceptable = true;
                    break;
                } else {
                    koef1 = new int[P1 + 1];
                    System.out.println("Koeficienty prvniho polynomu (cele cislo): ");
                    for (int i = (koef1.length - 1); i >= 0; i--) { // zadavani koeficinetu do pole od zadu podle stupne
                                                                    // polynomu
                        koef1[i] = UI.sc.nextInt();

                    }
                    System.out.println();
                    System.out.println("Stupen druheho polynomu (cele kladne cislo): ");

                    if ((P2 = UI.sc.nextInt()) < 0) {
                        isNotAcceptable = true;
                        break;
                    } else {
                        koef2 = new int[P2 + 1];

                        System.out.println("Koeficienty druheho polynomu (cele cislo): ");
                        for (int i = (koef2.length - 1); i >= 0; i--) {
                            koef2[i] = UI.sc.nextInt();

                        }
                        System.out.println();
                    }

                    outputPolynoms();
                }

            } while (!isNotAcceptable);
        } catch (Exception e) {
            System.out.println();
            System.out.println("ZADEJTE SPRAVNE HODNOTY!"); // jakmile se zada jina nez celociselna hodnota, tak se
                                                            // program vypne
            System.exit(0);
        }
    }

    public static String vypis(int[] a) {

        String vypisString = "";

        for (int i = (a.length - 1); i > 0; i--) {
            if (a[i] != 0) {
                if (a[i] == 1 && i == 1) {
                    vypisString += String.format("+x ");
                } else if (a[i] == -1 && i == 1) {
                    vypisString += String.format("-x ");
                } else if (i == 1) {
                    vypisString += String.format("%+dx ", a[i]);
                } else if (a[i] == 1) {
                    vypisString += String.format("+x^%d ", i);
                } else if (a[i] == -1) {
                    vypisString += String.format("-x^%d ", i);
                } else {
                    vypisString += String.format("%+dx^%d ", a[i], i);
                }
            }
        }
        vypisString += String.format("%+d", a[0]);

        return vypisString;
    }

    /**
     * Metoda pro vypis 1. polynomu
     * 
     * @return vystupPolynom1
     */
    public static String polynom1() {
        String vystupPolynom1 = "";

        System.out.print("Prvni polynom: ");
        for (int i = (koef1.length - 1); i > 0; i--) { // procházení pole od zadu pro správný výpis do String retezce
            if (koef1[i] != 0) {
                if (koef1[i] == 1 && i == 1) {
                    vystupPolynom1 += String.format("+x ");
                } else if (koef1[i] == -1 && i == 1) {
                    vystupPolynom1 += String.format("-x ");
                } else if (i == 1) {
                    vystupPolynom1 += String.format("%+dx ", koef1[i]);
                } else if (koef1[i] == 1) {
                    vystupPolynom1 += String.format("+x^%d ", i);
                } else if (koef1[i] == -1) {
                    vystupPolynom1 += String.format("-x^%d ", i);
                } else {
                    vystupPolynom1 += String.format("%+dx^%d ", koef1[i], i);
                }
            }
        }
        vystupPolynom1 += String.format("%+d", koef1[0]);
        return vystupPolynom1;
    }

    /**
     * Metoda pro vypis 2. polynomu
     * 
     * @return vystupPolynom2
     */
    public static String polynom2() {
        String vystupPolynom2 = "";
        System.out.print("Druhy polynom: ");

        for (int i = (koef2.length - 1); i > 0; i--) {
            if (koef2[i] != 0) {
                if (koef2[i] == 1 && i == 1) {
                    vystupPolynom2 += String.format("+x ");
                } else if (koef2[i] == -1 && i == 1) {
                    vystupPolynom2 += String.format("-x ");
                } else if (i == 1) {
                    vystupPolynom2 += String.format("%+dx ", koef2[i]);
                } else if (koef2[i] == 1) {
                    vystupPolynom2 += String.format("+x^%d ", i);
                } else if (koef2[i] == -1) {
                    vystupPolynom2 += String.format("-x^%d ", i);
                } else {
                    vystupPolynom2 += String.format("%+dx^%d ", koef2[i], i);
                }
            }
        }
        vystupPolynom2 += String.format("%+d \n", koef2[0]);

        return vystupPolynom2;
    }

    /**
     * Metoda pro vypocet a vypis soucinu polynomu
     * 
     * @return vystupSoucin
     */
    public static int[] soucin(int[] a, int[] b) {
        int[] soucinPole = new int[P1 + P2 + 1]; 

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int pomoc = i + j;
                soucinPole[pomoc] += a[i] * b[j]; 
            } 
        }

        return soucinPole;
    }

    /**
     * Metoda pro vypocet a vypis souctu polynomu
     * 
     * @return vystupSoucet
     */
    public static int[] soucet(int[] a, int[] b) {
        if (a.length >= b.length) { 
            soucetPole = new int[a.length]; 
            for (int i = 0; i < a.length; i++) { 
                soucetPole[i] += a[i];

            }
            for (int i = 0; i < b.length; i++) {
                soucetPole[i] += b[i];
            }
        } else {
            soucetPole = new int[b.length];
            for (int i = 0; i < b.length; i++) {
                soucetPole[i] += b[i];

            }
            for (int i = 0; i < a.length; i++) {
                soucetPole[i] += a[i];
            }
        }
        return soucetPole;
    }

    /**
     * Metoda pro vypis ostatnich metod
     */
    public static void outputPolynoms() {
        System.out.println("Prvni polynom: ");
        System.out.println(vypis(koef1)+"\n");
        System.out.println("Druhy polynom: ");
        System.out.println(vypis(koef2)+"\n");
        System.out.println("Soucet: ");
        System.out.println(vypis(soucet(koef1,koef2))+"\n");
        System.out.println("Soucin: ");
        System.out.println(vypis(soucin(koef1,koef2))+"\n");

    }

    public static void main(String[] args) {
        start();
        // outputPolynoms();
    }

}
