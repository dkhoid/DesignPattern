// Mẫu Factory method cho phép tạo đối tượng mà không cần biết cụ thể lớp nào đang được tạo. 
// Mục tiêu chính của mẫu này là tạo một interface (hoặc lớp trừu tượng) để tạo đối tượng. Các lớp con của nó sẽ quyết định đối tượng tạo ra. 

// Ví dụ, trong một ứng dụng GUI, bạn có thể cần tạo các nút và ô nhập liệu cho các hệ điều hành khác nhau (Windows, Mac) mà không cần biết cụ thể lớp nào sẽ được sử dụng.


// Abstract superclass with factory method
abstract class Animal {
    // Factory method
    public abstract Animal createAnimal();
    
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Concrete subclass Dog
class Dog extends Animal {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
    
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

// Concrete subclass Cat
class Cat extends Animal {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
    
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Animal dogFactory = new Dog();
        Animal dog = dogFactory.createAnimal();
        dog.makeSound();  // Output: Woof
        
        Animal catFactory = new Cat();
        Animal cat = catFactory.createAnimal();
        cat.makeSound();  // Output: Meow
    }
}

// In this example, the `Animal` class is an abstract class with a factory method `createAnimal()`.
// The `Dog` and `Cat` classes are concrete subclasses that implement the factory method to create instances of themselves.
// The client code uses the factory method to create instances of `Dog` and `Cat` without needing to know the specific classes being instantiated.


// This allows for flexibility and extensibility, as new animal types can be added without modifying the existing code.
// The factory method pattern is particularly useful when the creation process is complex or involves multiple steps, as it encapsulates the instantiation logic within the subclasses.
// This pattern promotes loose coupling and adheres to the Open/Closed Principle, allowing the code to be open for extension but closed for modification.
