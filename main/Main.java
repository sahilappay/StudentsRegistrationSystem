package main;

import beans.Student;
import config.Config;
import util.InputUtil;
import util.StudentUtil;

public class Main {

    public static void main(String[] args) {
        while (true) {

            int menu = InputUtil.requireNumber("Etmek istediyiniz emeliyyati sechin:" +
                    "\n 1. Telebeleri sisteme daxil edin." +
                    "\n 2. Sistemdeki telebelere bax." +
                    "\n 3. Sistemde telebe axtar." +
                    "\n 4. Telebeler haqqinda melumatlara duzelish et." +
                    "\n 5. Sistemden chix.");
            if (menu == 1) {
                StudentUtil.registerStudents();
            } else if (menu == 2) {
                StudentUtil.printAllRegisteredStudents();
            } else if (menu == 3) {
                String text = InputUtil.requireText("Axtardiginiz telebenin ad, soy ad ve ya sinifini daxil edin:");
                StudentUtil.findAndPrintStudents(text);
            } else if (menu == 4) {
                StudentUtil.findAndEditStudentsWithSplit();
            } else if (menu == 5) {
                System.out.println("Sistemden chixildi!");
                System.exit(0);
            }
        }
    }
}
