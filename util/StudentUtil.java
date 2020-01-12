package util;

import beans.Student;
import config.Config;

public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requireName();
        String surname = InputUtil.requireSurname();
        int age = InputUtil.requireAge();
        String className = InputUtil.requireClassName();

        Student student = new Student(name, surname, age, className);
        return student;
    }

    public static void printAllRegisteredStudents() {

        if (Config.students == null) {
            InputUtil.showNotFoundMesssage();
            return;         //config clasinin ichindeki students arrayi boshdursa metoddan chixir, eks halda else`ye kechir
        } else {
            for (int i = 0; i < Config.students.length; i++) {
                System.out.println((i + 1) + "." + Config.students[i].getFullİnfo());     //i-ci telebeni print edir
            }
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("Nece nefer daxil etmek isteyirsi?");
        Config.students = new Student[count];     // config clasinin ichindeki students arrayine count olchusunde yeni array menimsedilir

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "`ci telebenin melumatlarini daxil edin");
            Student student = StudentUtil.fillStudent();  //her dovrde yeni obyekt yaradilir ve melumatlari doldurularaq students arrayinin i-sine menimsedilir
            Config.students[i] = student;
        }

        InputUtil.showSuccesOpMessage();
        StudentUtil.printAllRegisteredStudents();  // butun telebeler chap edilir
    }

    public static Student[] findStudents(String text) {
        if (Config.students == null) {
            InputUtil.showNotFoundMesssage();
            return null;
        } else {
            int count = 0;
            for (int i = 0; i < Config.students.length; i++) {
                Student student = Config.students[i];
                if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                    count++; // her dovrde metoda gonderilen metne uygun telebeler bir-bir tapilir ve count deyisheninin deyiri 1 vahid artirilir
                }
            }
            int found = 0;
            Student[] rersult = new Student[count]; // tapilmish teleberin sayina uygun array yaradilir
            for (int i = 0; i < Config.students.length; i++) {
                Student student = Config.students[i];
                if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                    rersult[found++] = student; // yeniden metoda gonderilen text`e uygun telebeler bir-bir tapilir
                    // ve yuxarida yaratdigimiz result arrayine doldurulur. found deyisheni 0`dan bashlayaraq her dovrde 1 vahid artir
                }
            }
            return rersult;
        }
    }

    public static void findAndPrintStudents(String text) {
        if (Config.students == null) {
            InputUtil.showNotFoundMesssage();
            return;
        } else {
            Student[] students = findStudents(text);
            for (int i = 0; i < students.length; i++) {
                System.out.println(students[i].getFullİnfo());
            }
        }
    }

    public static void findAndEditStudentsWithConteins() {
        if (Config.students == null) {
            InputUtil.showNotFoundMesssage();
            return;
        } else {
            StudentUtil.printAllRegisteredStudents();
            int index = InputUtil.requireNumber("Nechenci telebenin melumatlarini yenilemek isteyirsiniz?");
            String parameters = InputUtil.requireText("Hansi parametrleri deyishmek isteyirsiniz (mes: 'ad' 'soyad' 'yash' 'sinif')?");
            System.out.println("Yeni melumatlari daxil edin");
            if (parameters.contains("'ad'")) {
                Config.students[index - 1].setName(InputUtil.requireName());
            }
            if (parameters.contains("'soyad'")) {
                Config.students[index - 1].setSurname(InputUtil.requireSurname());
            }
            if (parameters.contains("'yash'")) {
                Config.students[index - 1].setAge(InputUtil.requireAge());
            }
            if (parameters.contains("'sinif'")) {
                Config.students[index - 1].setClassName(InputUtil.requireClassName());
            }

            printAllRegisteredStudents();
        }
    }

    public static void findAndEditStudentsWithSplit() {
        if (Config.students == null) {
            InputUtil.showNotFoundMesssage();
            return;
        } else {
            StudentUtil.printAllRegisteredStudents();
            int index = InputUtil.requireNumber("Nechenci telebenin melumatlarini yenilemek isteyirsiniz?");
            String parameter = InputUtil.requireText("Hansi parametrleri deyishmek isteyirsiniz (mes: ad, soyad, yash, sinif)?");

            String[] parameters = parameter.split(",");

            System.out.println("Yeni melumatlari daxil edin");
            for (int i = 0; i < parameters.length; i++) {
                String param = parameters[i].trim();
                if (param.equalsIgnoreCase("ad")) {
                    Config.students[index - 1].setName(InputUtil.requireName());
                } else if (param.equalsIgnoreCase("soyad")) {
                    Config.students[index - 1].setSurname(InputUtil.requireSurname());
                } else if (param.equalsIgnoreCase("yash")) {
                    Config.students[index - 1].setAge(InputUtil.requireAge());
                } else if (param.equalsIgnoreCase("sinif")) {
                    Config.students[index - 1].setClassName(InputUtil.requireClassName());
                }else {
                    System.out.println("Yalnish parametr!");
                }
            }
            InputUtil.showSuccesOpMessage();
            printAllRegisteredStudents();
        }
    }
}
