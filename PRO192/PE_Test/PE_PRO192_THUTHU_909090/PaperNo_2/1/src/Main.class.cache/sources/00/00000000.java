package defpackage;

import java.util.Scanner;

/* renamed from: Main  reason: default package */
/* loaded from: Main.class */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter desert: ");
        String xDesert = sc.nextLine();
        System.out.print("Enter step: ");
        int xStep = sc.nextInt();
        sc.nextLine();
        System.out.println("1. Test getDesert()");
        System.out.println("2. Test setStep()");
        System.out.print("Enter TC (1 or 2): ");
        int tc = sc.nextInt();
        sc.nextLine();
        Camel t = new Camel(xDesert, xStep);
        if (tc == 2) {
            System.out.print("Enter new step: ");
            int xStep2 = sc.nextInt();
            sc.nextLine();
            t.setStep(xStep2);
        }
        System.out.println("OUTPUT:");
        switch (tc) {
            case 1:
                String u = t.getDesert();
                System.out.printf("%s\r\n", u);
                break;
            case 2:
                int v = t.getStep();
                System.out.printf("%d\r\n", Integer.valueOf(v));
                break;
            default:
                return;
        }
        System.out.println();
    }
}