// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int xSong2 = false;
      System.out.println();
      System.out.print("Enter place: ");
      String xPlace = sc.nextLine();
      System.out.print("Enter song: ");
      int xSong = sc.nextInt();
      sc.nextLine();
      System.out.println("1. Test getPlace()");
      System.out.println("2. Test setSong()");
      System.out.print("Enter TC (1 or 2): ");
      int tc = sc.nextInt();
      sc.nextLine();
      Cannary t = new Cannary(xPlace, xSong);
      if (tc == 2) {
         System.out.print("Enter new song: ");
         int xSong2 = sc.nextInt();
         sc.nextLine();
         t.setSong(xSong2);
      }

      System.out.println("OUTPUT:");
      switch (tc) {
         case 1:
            String u = t.getPlace();
            System.out.printf("%s\r\n", u);
            break;
         case 2:
            int v = t.getSong();
            System.out.printf("%d\r\n", v);
            break;
         default:
            return;
      }

      System.out.println();
   }
}
