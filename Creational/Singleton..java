// Mẫu Singleton được định nghĩa là đảm bảo rằng chỉ có một thể hiện duy nhất của một lớp tồn tại và một điểm truy cập toàn cục vào nó tồn tại. Nó được sử dụng để đảm bảo rằng chỉ có một thể hiện của một lớp được tạo ra và truy cập được từ bất kỳ nơi nào trong chương trình.


// Lazy initialization
// Dùng khi khởi tạo instance là một hoạt động chậm chạp và có tác động đến hiệu suất của ứng dụng
public class Singleton_Lazy {
    private static synchronized Singleton_Lazy instance; // Dùng synchronized để đảm bảo rằng chỉ có một thread có thể truy cập vào getInstance() một lần, tránh trường hợp tạo ra nhiều instance của lớp khi đa nhiệm
    private Singleton_Lazy() {} // Dùng private để đảm bảo rằng không có thể tạo instance từ bên ngoài lớp
    public static Singleton_Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton_Lazy();
        }
        return instance;
    }
}

// Eager initialization
// Dùng khi khởi tạo instance là một hoạt động nhanh chóng và không có tác động đến hiệu suất của ứng dụng
public class Singleton_Eager {
    private static Singleton_Eager instance = new Singleton_Eager();
    private Singleton_Eager() {} // Dùng private để đảm bảo rằng không có thể tạo instance từ bên ngoài lớp
    public static Singleton_Eager getInstance() {
        return instance;
    }
}

// example
public class Logger {
    private static Logger instance;
    private Logger() {}
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class Application {
    public void run() {
        Logger logger = Logger.getInstance();
        logger.log("Application started.");
    }
}

public class UserService {
    public void createUser(String username) {
        Logger logger = Logger.getInstance();
        logger.log("Creating user: " + username);
    }
}

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();

        UserService userService = new UserService();
        userService.createUser("rokisaki");
    }
}



// advantages
// - Đảm bảo rằng chỉ có một thể hiện của một lớp được tạo ra
// - Cung cấp một điểm truy cập toàn cục vào một thể hiện của một lớp
// - Giúp giảm thiểu chi phí tạo ra các thể hiện của một lớp
// - Giúp giảm thiểu rủi ro khi có nhiều thể hiện của một lớp được tạo ra

//Advance: Double-checked locking
public class Singleton_DoubleCheckedLocking {
    private static volatile Singleton_DoubleCheckedLocking instance;
    private Singleton_DoubleCheckedLocking() {}
    public static Singleton_DoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (Singleton_DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Singleton_DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}





