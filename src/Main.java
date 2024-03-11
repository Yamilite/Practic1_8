import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static List<Doctor> doctorsList = new ArrayList<>();
    private static Map<Integer, Doctor> doctorsMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Заполнение начальными значениями
        doctorsList.add(new Doctor("Антонов Антон Антонович", "терапевт", 345, 15, true));
        doctorsList.add(new Doctor("Иванов Иван Иванович", "хирург", 5, 20, true));
        doctorsList.add(new Doctor("Юрьев Юрий Аристархович", "офтальмолог", 65, 10, false));

        // Заполнение Map для быстрого доступа по порядковому номеру
        for (Doctor doctor : doctorsList) {
            doctorsMap.put(doctor.employeeNumber, doctor);
        }

        // Основной цикл программы
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового врача");
            System.out.println("2. Изменить флаг аттестации для врача");
            System.out.println("3. Вывести список врачей с сортировкой по ФИО");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний перевод строки после ввода числа

            switch (choice) {
                case 1:
                    addNewDoctor();
                    break;
                case 2:
                    changeCertificationStatus();
                    break;
                case 3:
                    displayDoctorsListSortedByName();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод. Повторите попытку.");
            }
        }
    }

    private static void addNewDoctor() {
        System.out.println("\nВведите данные нового врача:");

        System.out.print("ФИО: ");
        String fullName = scanner.nextLine();

        System.out.print("Специальность: ");
        String specialty = scanner.nextLine();

        System.out.print("Порядковый номер: ");
        int employeeNumber = scanner.nextInt();

        if (doctorsMap.containsKey(employeeNumber)) {
            System.out.println("Врач с таким порядковым номером уже существует.");
            return;
        }

        System.out.print("Количество рабочих смен в месяц: ");
        int workShiftsPerMonth = scanner.nextInt();

        System.out.print("Отметка о прохождении аттестации (true/false): ");
        boolean certification = scanner.nextBoolean();

        Doctor newDoctor = new Doctor(fullName, specialty, employeeNumber, workShiftsPerMonth, certification);
        doctorsList.add(newDoctor);
        doctorsMap.put(employeeNumber, newDoctor);

        System.out.println("Новый врач успешно добавлен.");
        displayDoctorsListSortedByName();
    }

    private static void changeCertificationStatus() {
        System.out.println("\nВведите порядковый номер врача для изменения статуса аттестации:");
        int employeeNumber = scanner.nextInt();

        if (!doctorsMap.containsKey(employeeNumber)) {
            System.out.println("Врач с таким порядковым номером не найден.");
            return;
        }

        Doctor doctor = doctorsMap.get(employeeNumber);
        doctor.certification = !doctor.certification;

        System.out.println("Статус аттестации для врача с порядковым номером " + employeeNumber + " успешно изменен.");
        displayDoctorsListSortedByName();
    }

    private static void displayDoctorsListSortedByName() {
        System.out.println("\nСписок врачей с сортировкой по ФИО:");

        // Сортировка списка врачей по ФИО
        Collections.sort(doctorsList, Comparator.comparing(doctor -> doctor.fullName));

        // Вывод отсортированного списка
        for (Doctor doctor : doctorsList) {
            System.out.println(doctor);
        }
    }
}