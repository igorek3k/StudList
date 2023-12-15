package org.example;

import ru.esstu.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studList;
        boolean exitProgram = false;

        while (true) {
            System.out.println("Выберите реализацию:");
            System.out.println("1 - Лист");
            System.out.println("2 - Текстовые файлы");
            System.out.println("3 - XML файл");
            System.out.println("4 - JSON файл");
            System.out.println("5 - Выйти");
            System.out.print("Выберите действие (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                studList = new StudentListArrayList();
                break;
            } else if (choice == 2) {
                System.out.print("Введите название папки для хранения файлов: ");
                String directory = scanner.next();
                studList = new StudentListFile(directory);
                break;
            } else if (choice == 3) {
                System.out.print("Введите название файла XML: ");
                String xmlFileName = scanner.next();
                studList = new StudentListXML(xmlFileName);
                break;
            } else if (choice == 4) {
                System.out.print("Введите название файла JSON: ");
                String jsonFileName = scanner.next();
                studList = new StudentListJSON(jsonFileName);
                break;
            } else if (choice == 5) {
                System.exit(0);
            } else {
                System.out.println("Ошибка, введите 1 - 5");
            }
        }

        while(!exitProgram) {
            System.out.println("Меню:");
            System.out.println("1 - Вызвать список студентов");
            System.out.println("2 - Добавить студента");
            System.out.println("3 - Редактировать студента");
            System.out.println("4 - Удалить студента");
            System.out.println("5 - Выйти");

            System.out.print("Выберите действие (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayStudents(studList);
                    break;
                case 2:
                    addStudent(scanner, studList);
                    break;
                case 3:
                    editStudent(scanner, studList);
                    break;
                case 4:
                    deleteStudent(scanner, studList);
                    break;
                case 5:
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Ошибка, введите 1 - 5");
            }
        }
    }

    private static void displayStudents(StudentList studentList) {
        System.out.println("Список студентов:");
        if(studentList.getAll().isEmpty())
            System.out.println("Пусто");
        for (Student student : studentList.getAll()) {
            System.out.println("Студент №" + student.getId() + " "
                    + student.getLastName() + " " + student.getFirstName() + " "
                    + student.getMiddleName() + " группы " + student.getGroup());
        }
    }

    private static void addStudent(Scanner scanner, StudentList studentList) {
        System.out.print("Введите ID студента: ");
        String id = scanner.next();
        System.out.print("Введите имя студента: ");
        String firstName = scanner.next();
        System.out.print("Введите фамилию студента: ");
        String lastName = scanner.next();
        System.out.print("Введите отчество студента: ");
        String patronymicName = scanner.next();
        System.out.print("Введите группу студента: ");
        String group = scanner.next();

        Student student = new Student(id, firstName, lastName, patronymicName, group);
        studentList.add(student);
        System.out.println("Студент добавлен");
    }

    private static void editStudent(Scanner scanner, StudentList studentList) {
        System.out.print("Введите ID студента, которого хотите изменить: ");
        String id = scanner.next();
        Student existingStudent = studentList.getById(id);

        if (existingStudent != null) {
            System.out.print("Введите новое имя студента: ");
            String firstName = scanner.next();
            System.out.print("Введите новую фамилию студента: ");
            String lastName = scanner.next();
            System.out.print("Введите новое отчество студента: ");
            String middleName = scanner.next();
            System.out.print("Введите новую группу студента: ");
            String group = scanner.next();

            Student updatedStudent = new Student(id, firstName, lastName, middleName, group);
            studentList.update(updatedStudent);
            System.out.println("Студент изменен");
        } else {
            System.out.println("Студент с указанным ID не найден");
        }
    }

    private static void deleteStudent(Scanner scanner, StudentList studentList) {
        System.out.print("Введите ID студента, которого хотите удалить: ");
        String id = scanner.next();
        Student existingStudent = studentList.getById(id);

        if (existingStudent != null) {
            studentList.delete(id);
            System.out.println("Студент удален");
        } else {
            System.out.println("Студент с указанным ID не найден");
        }
    }
}