package researcher;

import it.ewlab.researcher.StudentOuterClass;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 6789);

        StudentOuterClass.Student student =
                StudentOuterClass.Student.newBuilder()
                        .setName("Mattia")
                        .setSurname("Fasoli")
                        .setYearOfBirth(1998)
                        .setResidence(
                                StudentOuterClass.Student.Residence.newBuilder()
                                        .setAddress("Via Solferino, 44")
                                        .setCity("Milano")
                                        .setCap(20121)
                        )
                        .addExam(
                                StudentOuterClass.Student.Exam.newBuilder()
                                        .setName("SDP")
                                        .setMark(21)
                                        .setDate("2022/01/31")
                        )
                        .build();

        student.writeTo(clientSocket.getOutputStream());

        clientSocket.close();

    }
}
