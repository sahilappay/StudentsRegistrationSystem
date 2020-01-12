package util;

import java.util.Scanner;

public class InputUtil {

    /* requireText metodu  bizim gonderdiyimiz metni ekrana chixarmaqla mushteriden
    *  string tipde deyer alir ve aldigi deyeri return edir
    * */
    public static String requireText(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        String value = sc.nextLine();
        return value;
    }

    /* requireNumber metodu  bizim gonderdiyimiz metni ekrana chixarmaqla mushteriden
     *  int tipde deyer alir ve aldigi deyeri return edir
     * */
    public static int requireNumber(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        int value = sc.nextInt();
        return value;
    }

    public static String requireName(){
        return requireText("Adi daxil edin:");
    }

    public static String requireSurname(){
        return requireText("Soyadi daxil edin:");
    }

    public static String requireClassName(){
        return requireText("Sinifi daxil edin:");
    }

    public static int requireAge(){
        return requireNumber("Yashi daxil edin:");
    }

    public static void showSuccesOpMessage(){
        System.out.println("Emeliyyat ugurla icra edildi!");
    }

    public static void showNotFoundMesssage(){
        System.out.println("Sistemde hech bir telebe tapilmadi!");
    }

}
