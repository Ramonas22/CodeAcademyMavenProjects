import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class StudentService {


    public void createStudent(Session session){

        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student name");
        student.setName(scanner.nextLine());

        System.out.println("Enter Student surname");
        student.setSurname(scanner.nextLine());

        System.out.println("Enter Student course");
        student.setCourse(scanner.nextInt());

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public List<Student> readStudentList(Session session){
        return session.createQuery("from Student").list();
    }

    public Student readStudentById(Session session, Integer id){
        return (Student) session.createQuery("from Student where Id = :student_id").setParameter("student_id", id).list().get(0);
    }

    public List<Student> readStudentsByCourse(Session session, Integer course){
        return session.createQuery("from Student where course = :id_course").setInteger("id_course", course).list();
    }

    public void updateStudent(Session session, Integer id){
        Scanner scanner = new Scanner(System.in);
        int temp;

        do{
            printUpdateOptions();
            temp = scanner.nextInt();
            switch (temp){
                case 1 -> updateName(session, id);
                case 2 -> updateSurname(session, id);
                case 3 -> updateCourse(session, id);
                case 4 -> System.out.println("");
                default -> System.out.println("Entered wrong command try again");
            }
        }while (temp !=4);
    }


    private void updateName(Session session, Integer id) {
        Scanner scanner = new Scanner(System.in);
        Student student = readStudentById(session,id);
        System.out.println("Enter new name");
        student.setName(scanner.nextLine());
        session.update(student);
    }

    private void updateSurname(Session session, Integer id) {
        Scanner scanner = new Scanner(System.in);
        Student student = readStudentById(session,id);
        System.out.println("Enter new surname");
        student.setSurname(scanner.nextLine());
        session.update(student);
    }

    private void updateCourse(Session session, Integer id) {
        Scanner scanner = new Scanner(System.in);
        Student student = readStudentById(session,id);
        System.out.println("Enter new course");
        student.setCourse(scanner.nextInt());
        session.update(student);
    }

    private void printUpdateOptions(){
        System.out.println("""
                [1] Update name
                [2] Update surname
                [3] Update course
                [4] Exit
                """);
    }

    public void deleteStudent(Session session, Integer id){
        Student student = readStudentById(session,id);
        session.delete(student);
    }

    public void runProgram(Session session){
        Scanner scanner = new Scanner(System.in);
        int temp;

        do {
            printRunProgramOptions();
            temp = scanner.nextInt();

            switch (temp){
                case 1->createStudent(session);
                case 2->printStudentsList(readStudentList(session));
                case 3->{
                    System.out.println("Enter Id");
                    printStudent(readStudentById(session, scanner.nextInt()));
                }
                case 4->{
                    System.out.println("Enter course");
                    printStudentsList(readStudentsByCourse(session, scanner.nextInt()));}
                case 5-> {
                    System.out.println("Enter Id");
                    updateStudent(session, scanner.nextInt());
                }
                case 6-> {
                    System.out.println("Enter Id");
                    deleteStudent(session, scanner.nextInt());
                }
                case 7 -> System.out.println("Bye bye");
                default -> System.out.println("Entered wrong command try again");
            }

        }while (temp!=7);
    }


    private void printRunProgramOptions() {
        System.out.println("""
                [1] Create new student
                [2] Read all students
                [3] Read student by id
                [4] Read students by course
                [5] Update student by id
                [6] Delete student by id
                [7] Exit
                """);
    }

    private void printStudentsList(List<Student> students){
        for (Student student: students
             ) {
            System.out.printf("\nStudent ID %d Student name %s surname %s course %d",
                    student.getId(),student.getName(),student.getSurname(),student.getCourse());
        }
    }
    private void printStudent(Student student) {
        System.out.printf("Student ID %d Student name %s surname %s course %d\n",
                student.getId(),student.getName(),student.getSurname(),student.getCourse());
    }
}
