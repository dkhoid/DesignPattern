// Abstract Factory là một mẫu thiết kế sáng tạo (creational pattern) cung cấp một giao diện để tạo ra các họ đối tượng liên quan hoặc phụ thuộc lẫn nhau mà không cần chỉ định cụ thể các lớp của chúng. Nói đơn giản, nó giống như một "nhà máy của các nhà máy" (factory of factories), giúp tạo ra các đối tượng thuộc nhiều loại khác nhau nhưng có sự liên kết với nhau.

//Ví dụ: Trong một ứng dụng giao diện người dùng (GUI), bạn có thể cần tạo các thành phần như nút (button) và ô nhập liệu (text field) cho các hệ điều hành khác nhau (Windows, Mac).

// Use case:
// Khi hệ thống cần độc lập với cách các đối tượng được tạo ra, tổ hợp và biểu diễn.
// Khi hệ thống cần được cấu hình với một trong nhiều họ đối tượng liên quan.
// Khi bạn muốn đảm bảo các đối tượng được tạo ra tương thích với nhau.


public interface GUIFactory { //abstract factory
    Button createButton();
    TextField createTextField();
}

//concrete factories
public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public TextField createTextField() {
        return new WindowsTextField();
    }
}

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public TextField createTextField() {
        return new MacTextField();
    }
}

//abstract products
public interface Button {
    void render();
}

public interface TextField {
    void render();
}

//concrete products
public class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

public class WindowsTextField implements TextField {
    public void render() {
        System.out.println("Rendering Windows TextField");
    }
}

public class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

public class MacTextField implements TextField {
    public void render() {
        System.out.println("Rendering Mac TextField");
    }
}
// Client code
public class Application {
    private Button button;
    private TextField textField;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        textField = factory.createTextField();
    }

    public void render() {
        button.render();
        textField.render();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        
        // Giả sử chúng ta muốn tạo giao diện cho Windows
        factory = new WindowsFactory();
        
        Application app = new Application(factory);
        app.render();

        // Nếu chúng ta muốn chuyển sang Mac
        factory = new MacFactory();
        app = new Application(factory);
        app.render();
    }
}
