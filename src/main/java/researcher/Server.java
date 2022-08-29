package researcher;

import it.ewlab.researcher.StudentOuterClass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(6789);

        Socket socket = serverSocket.accept();

        StudentOuterClass.Student student = StudentOuterClass.Student.parseFrom(socket.getInputStream());

        System.out.println(student);
    }


}
