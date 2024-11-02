
# Tài liệu ôn thi PRO192 - Lập trình Java (JDK 1.8, NetBeans 8.x)

## 1. Cơ bản về Java

### 1.1. Cấu trúc chương trình Java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

- Mọi code Java phải nằm trong một class
- Tên file phải trùng với tên class chính và có đuôi .java
- Phương thức `main` là điểm bắt đầu của chương trình

### 1.2. Kiểu dữ liệu
- Kiểu nguyên thủy: `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`
- Kiểu tham chiếu: `String`, arrays, objects

### 1.3. Biến và hằng số

#### Biến (Variables)
Biến là một vùng nhớ được đặt tên để lưu trữ dữ liệu.

Cú pháp khai báo biến:
```java
kiểu_dữ_liệu tên_biến [= giá_trị_khởi_tạo];
```

Ví dụ:
```java
int age = 25;  // Biến số nguyên
double salary = 5000.50;  // Biến số thực
String name = "John";  // Biến chuỗi
boolean isStudent = true;  // Biến boolean
char grade = 'A';  // Biến ký tự
```

Lưu ý:
- Tên biến phải bắt đầu bằng chữ cái, dấu gạch dưới (_) hoặc dấu đô la ($).
- Tên biến không được trùng với từ khóa của Java.
- Tên biến nên tuân theo quy tắc camelCase (ví dụ: firstName, lastLoginDate).

#### Hằng số (Constants)
Hằng số là biến có giá trị không thay đổi trong suốt chương trình.

Cú pháp khai báo hằng số:
```java
final kiểu_dữ_liệu TÊN_HẰNG_SỐ = giá_trị;
```

Ví dụ:
```java
final double PI = 3.14159265359;
final int MAX_USERS = 100;
final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
```

Lưu ý:
- Từ khóa `final` được sử dụng để khai báo hằng số.
- Tên hằng số thường viết hoa và sử dụng dấu gạch dưới để ngăn cách các từ.
- Giá trị của hằng số phải được khởi tạo khi khai báo và không thể thay đổi sau đó.

#### Phạm vi của biến (Variable Scope)

1. Biến cục bộ (Local Variables):
   - Được khai báo trong một phương thức hoặc khối lệnh.
   - Chỉ có thể truy cập trong phạm vi khai báo.

2. Biến thành viên (Instance Variables):
   - Được khai báo trong một lớp, ngoài các phương thức.
   - Mỗi đối tượng của lớp có một bản sao riêng.

3. Biến tĩnh (Static Variables):
   - Được khai báo với từ khóa `static`.
   - Chỉ có một bản sao duy nhất cho tất cả các đối tượng của lớp.

Ví dụ:
```java
public class VariableExample {
    static int staticVar = 0;  // Biến tĩnh
    int instanceVar;  // Biến thành viên

    public void method() {
        int localVar = 10;  // Biến cục bộ
        System.out.println(localVar);
    }
}
```
#### Ép kiểu (Casting)
Chuyển đổi giá trị từ một kiểu dữ liệu sang kiểu khác. Có hai loại ép kiểu chính:

1. Ép kiểu ngầm định (Widening Casting):
   - Chuyển đổi từ kiểu dữ liệu nhỏ hơn sang kiểu dữ liệu lớn hơn.
   - Được thực hiện tự động bởi Java, không cần khai báo rõ ràng.
   - Không làm mất dữ liệu.
   ```java
   int myInt = 9;
   double myDouble = myInt;  // Tự động ép kiểu từ int sang double
   ```
   Giải thích: Ở đây, giá trị int 9 được tự động chuyển đổi thành 9.0 (double) mà không cần khai báo rõ ràng.

2. Ép kiểu tường minh (Narrowing Casting):
   - Chuyển đổi từ kiểu dữ liệu lớn hơn sang kiểu dữ liệu nhỏ hơn.
   - Phải được khai báo rõ ràng bằng cách đặt kiểu dữ liệu trong dấu ngoặc đơn trước giá trị.
   - Có thể làm mất dữ liệu hoặc độ chính xác.
   ```java
   double myDouble = 9.78;
   int myInt = (int) myDouble;  // Ép kiểu tường minh từ double sang int
   ```
   Giải thích: Ở đây, giá trị double 9.78 bị cắt bỏ phần thập phân và chỉ giữ lại phần nguyên 9 khi chuyển sang int.

Lưu ý: 
- Ép kiểu ngầm định an toàn và không làm mất dữ liệu.
- Ép kiểu tường minh có thể làm mất dữ liệu hoặc độ chính xác, cần cẩn thận khi sử dụng.
- Khi ép kiểu tường minh, lập trình viên phải chịu trách nhiệm đảm bảo tính đúng đắn của dữ liệu sau khi chuyển đổi.

## 2. Hàm (Methods) trong Java

Hàm trong Java, còn được gọi là phương thức (method), là một khối mã thực hiện một nhiệm vụ cụ thể và có thể được gọi từ các phần khác của chương trình.

### 2.1. Cấu trúc cơ bản của hàm

```java
[modifier] returnType methodName([parameterList]) {
    // Method body
    [return statement;]
}
```

- `modifier`: Xác định phạm vi truy cập (public, private, protected) và các đặc điểm khác (static, final, abstract).
- `returnType`: Kiểu dữ liệu của giá trị trả về hoặc `void` nếu không trả về giá trị.
- `methodName`: Tên của hàm, tuân theo quy tắc đặt tên trong Java.
- `parameterList`: Danh sách các tham số (có thể không có).

### 2.2. Các loại hàm

#### 2.2.1. Hàm có giá trị trả về

Hàm này trả về một giá trị cụ thể sau khi thực hiện xong.

```java
public class Calculator {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = sum(2, 5);
        System.out.println("Sum: " + result);  // Output: Sum: 7
    }
}
```

#### 2.2.2. Hàm không có giá trị trả về (void)

Hàm này thực hiện một tác vụ nhưng không trả về giá trị.

```java
public class Printer {
    public static void printSum(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    public static void main(String[] args) {
        printSum(2, 5);  // Output: Sum: 7
    }
}
```

### 2.3. Tham số và đối số

- Tham số (Parameters): Biến được khai báo trong định nghĩa hàm.
- Đối số (Arguments): Giá trị thực tế được truyền vào khi gọi hàm.

```java
public static void greet(String name) {  // name là tham số
    System.out.println("Hello, " + name);
}

public static void main(String[] args) {
    greet("Alice");  // "Alice" là đối số
}
```

### 2.4. Overloading (Nạp chồng) hàm

Java cho phép định nghĩa nhiều hàm cùng tên nhưng khác nhau về số lượng hoặc kiểu tham số.

```java
public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 3));       // Calls int version
        System.out.println(add(5.5, 3.2));   // Calls double version
    }
}
```

### 2.5. Hàm đệ quy (Recursive method)

Hàm gọi chính nó trong thân hàm.

```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Output: 120
    }
}
```

### 2.6. Hàm với kiểu boolean

Hàm trả về giá trị `true` hoặc `false`.

```java
public class NumberChecker {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(4));  // Output: true
        System.out.println(isEven(7));  // Output: false
    }
}
```

### 2.7. Lưu ý quan trọng

1. Tên hàm nên bắt đầu bằng một động từ và tuân theo quy tắc camelCase.
2. Hàm nên thực hiện một nhiệm vụ cụ thể và có tên mô tả rõ nhiệm vụ đó.
3. Nếu hàm không trả về giá trị, sử dụng `void` làm kiểu trả về.
4. Khi sử dụng `return`, hàm sẽ kết thúc ngay lập tức, bất kể có còn code phía sau hay không.
5. Hàm static có thể được gọi mà không cần tạo đối tượng của lớp.

## 3. Cấu trúc điều khiển

### 3.1. Câu lệnh if-else
```java
int score = 85;

if (score >= 90) {
    System.out.println("Xuất sắc");
} else if (score >= 80) {
    System.out.println("Giỏi");
} else if (score >= 70) {
    System.out.println("Khá");
} else {
    System.out.println("Trung bình");
}
```

Lưu ý:
- Điều kiện trong if phải là biểu thức boolean (true/false)
- Có thể có nhiều else if
- else là tùy chọn và xử lý trường hợp còn lại

### 3.2. Switch
```java
int day = 3;
String dayName;

switch (day) {
    case 1:
        dayName = "Thứ Hai";
        break;
    case 2:
        dayName = "Thứ Ba";
        break;
    case 3:
        dayName = "Thứ Tư";
        break;
    // ... các case khác
    default:
        dayName = "Không hợp lệ";
}

System.out.println(dayName);
```

Lưu ý:
- Switch chỉ hoạt động với int, byte, short, char, enum, String (từ Java 7)
- Luôn sử dụng break để tránh "fall-through" (tức là nó sẽ chạy tiếp các case ở phía dưới chứ không phải dừng tại điểm bạn cần dừng).
- default xử lý trường hợp không khớp với bất kỳ case nào

### 3.3. Vòng lặp for

Vòng lặp for được sử dụng khi bạn biết trước số lần lặp.

Cấu trúc cơ bản:
```java
for (khởi_tạo; điều_kiện; bước_nhảy) {
    // Khối lệnh cần lặp lại
}
```

Ví dụ 1: In ra các số từ 1 đến 5
```java
for (int i = 1; i <= 5; i++) {
    System.out.print(i + " ");
}
```
Output:
```
1 2 3 4 5 
```

Giải thích:
1. `int i = 1`: Khởi tạo biến đếm i với giá trị 1.
2. `i <= 5`: Điều kiện để tiếp tục vòng lặp. Vòng lặp sẽ chạy khi i còn nhỏ hơn hoặc bằng 5.
3. `i++`: Tăng giá trị của i sau mỗi lần lặp.
4. Trong mỗi lần lặp, giá trị của i được in ra, theo sau bởi một khoảng trắng.
5. Vòng lặp thực hiện 5 lần với i lần lượt là 1, 2, 3, 4, 5.

Ví dụ 2: Tính tổng các số từ 1 đến n
```java
int n = 5;
int sum = 0;
for (int i = 1; i <= n; i++) {
    sum += i;
    System.out.print(i + (i < n ? " + " : " = "));
}
System.out.print(sum);
```
Output:
```
1 + 2 + 3 + 4 + 5 = 15
```

Giải thích:
1. `int n = 5`: Đặt giới hạn trên cho vòng lặp.
2. `int sum = 0`: Khởi tạo biến tổng.
3. Vòng lặp chạy từ 1 đến 5:
   - Mỗi lần lặp, cộng giá trị i vào sum.
   - In ra giá trị i, theo sau bởi "+" nếu chưa phải số cuối cùng, hoặc "=" nếu là số cuối.
4. Sau vòng lặp, in ra tổng cuối cùng.

Ví dụ 3: For-each loop
```java
String[] fruits = {"Apple", "Banana", "Cherry"};
for (String fruit : fruits) {
    System.out.print(fruit + " ");
}
```
Output:
```
Apple Banana Cherry 
```

Giải thích:
1. Tạo một mảng `fruits` chứa 3 chuỗi.
2. Vòng lặp for-each sẽ duyệt qua từng phần tử trong mảng `fruits`.
3. Trong mỗi lần lặp:
   - `fruit` sẽ lần lượt nhận giá trị của từng phần tử trong mảng.
   - Giá trị của `fruit` được in ra, theo sau bởi một khoảng trắng.
4. Vòng lặp tự động kết thúc sau khi đã duyệt qua tất cả phần tử trong mảng.

Lưu ý:
- For-each loop rất hữu ích khi bạn muốn duyệt qua tất cả phần tử của một mảng hoặc collection mà không cần quan tâm đến chỉ số.
- Tuy nhiên, for-each không cho phép bạn thay đổi các phần tử của mảng trong quá trình lặp.
### 3.4. Vòng lặp while và do-while

#### Vòng lặp while

Vòng lặp while được sử dụng khi bạn không biết trước số lần lặp và muốn lặp dựa trên một điều kiện.

Ví dụ: Đếm số chữ số của một số
```java
int number = 23456;
int count = 0;
while (number != 0) {
    number /= 10;
    count++;
}
System.out.println("Số chữ số: " + count);
```
Output:
```
Số chữ số: 5
```

#### Vòng lặp do-while

Vòng lặp do-while đảm bảo khối lệnh được thực hiện ít nhất một lần trước khi kiểm tra điều kiện.

Ví dụ: Nhập số từ bàn phím cho đến khi nhập số dương
```java
import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Nhập một số dương: ");
            number = scanner.nextInt();
        } while (number <= 0);
        System.out.println("Bạn đã nhập số: " + number);
    }
}
```
Input/Output có thể như sau:
```
Nhập một số dương: -5
Nhập một số dương: 0
Nhập một số dương: 7
Bạn đã nhập số: 7
```

Phân biệt while và do-while:

Ví dụ: So sánh while và do-while khi điều kiện sai ngay từ đầu
```java
int x = 5;

System.out.println("Using while loop:");
while (x < 5) {
    System.out.println("This will not be printed");
}

System.out.println("\nUsing do-while loop:");
do {
    System.out.println("This will be printed once");
} while (x < 5);
```
Output:
```
Using while loop:

Using do-while loop:
This will be printed once
```

Lưu ý:
- Trong ví dụ trên, khối lệnh trong while không được thực hiện lần nào.
- Khối lệnh trong do-while được thực hiện một lần dù điều kiện sai ngay từ đầu.

### 3.5. Break và Continue
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Thoát khỏi vòng lặp khi i = 5
    }
    if (i % 2 == 0) {
        continue; // Bỏ qua các số chẵn
    }
    System.out.println(i);
}
```

Lưu ý:
- break: thoát khỏi vòng lặp ngay lập tức
- continue: bỏ qua phần còn lại của vòng lặp hiện tại và chuyển sang lần lặp tiếp theo



# Những điểm quan trọng cần nhớ:

1. Luôn kiểm tra điều kiện dừng trong vòng lặp để tránh vòng lặp vô hạn.

2. Sử dụng cấu trúc điều khiển phù hợp với logic của bài toán.

3. Cẩn thận với việc sử dụng `break` và `continue`, đảm bảo không làm mất logic của chương trình.

4. Trong `switch-case`, luôn nhớ sử dụng `break` sau mỗi case (trừ khi cố ý muốn fall-through).

5. Khi sử dụng for-each, không thể thay đổi giá trị của phần tử trong collection gốc.

## 4. Mảng và ArrayList

### 4.1. Mảng (Array)

Mảng là một cấu trúc dữ liệu cơ bản trong Java, dùng để lưu trữ nhiều phần tử cùng kiểu dữ liệu.

#### Khai báo và khởi tạo mảng:
```java
// Khai báo mảng
int[] numbers;

// Khởi tạo mảng với kích thước cố định
numbers = new int[5];

// Khai báo và khởi tạo cùng lúc
int[] numbers = new int[5];

// Khai báo, khởi tạo và gán giá trị
int[] numbers = {1, 2, 3, 4, 5};
````


#### Truy cập và thay đổi phần tử:
````java
// Truy cập phần tử
int firstNumber = numbers[0];

// Thay đổi giá trị phần tử
numbers[1] = 10;
````


#### Duyệt mảng:
````java
// Sử dụng vòng lặp for
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// Sử dụng for-each
for (int number : numbers) {
    System.out.println(number);
}
````


#### Mảng đa chiều:
````java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[1][1]); // In ra: 5
````


### 4.2. ArrayList

ArrayList là một lớp trong Java Collections Framework, cung cấp mảng động có thể thay đổi kích thước.

#### Khai báo và khởi tạo ArrayList:
````java
import java.util.ArrayList;

// Khai báo ArrayList
ArrayList<String> list;

// Khởi tạo ArrayList
list = new ArrayList<>();

// Khai báo và khởi tạo cùng lúc
ArrayList<String> fruits = new ArrayList<>();
````


#### Thêm và xóa phần tử:
````java
// Thêm phần tử
fruits.add("Apple");
fruits.add("Banana");
fruits.add(1, "Orange"); // Thêm vào vị trí cụ thể

// Xóa phần tử
fruits.remove("Banana");
fruits.remove(0); // Xóa phần tử ở vị trí 0
````


#### Truy cập và thay đổi phần tử:
````java
// Truy cập phần tử
String firstFruit = fruits.get(0);

// Thay đổi giá trị phần tử
fruits.set(1, "Grape");
````


#### Duyệt ArrayList:
````java
// Sử dụng vòng lặp for
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}

// Sử dụng for-each
for (String fruit : fruits) {
    System.out.println(fruit);
}
````


#### Các phương thức hữu ích:
````java
int size = fruits.size(); // Kích thước của ArrayList
boolean isEmpty = fruits.isEmpty(); // Kiểm tra ArrayList có rỗng không
boolean contains = fruits.contains("Apple"); // Kiểm tra phần tử có tồn tại không
int index = fruits.indexOf("Banana"); // Tìm vị trí của phần tử
fruits.clear(); // Xóa tất cả phần tử
````


#### So sánh Mảng và ArrayList:

1. Kích thước:
   - Mảng: Kích thước cố định sau khi khởi tạo.
   - ArrayList: Kích thước có thể thay đổi động.

2. Kiểu dữ liệu:
   - Mảng: Có thể chứa kiểu nguyên thủy và đối tượng.
   - ArrayList: Chỉ có thể chứa đối tượng.

3. Hiệu suất:
   - Mảng: Nhanh hơn trong truy cập phần tử.
   - ArrayList: Chậm hơn một chút trong truy cập, nhưng linh hoạt hơn trong thêm/xóa.

4. Chức năng:
   - Mảng: Chức năng hạn chế.
   - ArrayList: Nhiều phương thức hữu ích như add(), remove(), contains(), etc.

#### Ví dụ thực tế:

Quản lý danh sách sinh viên sử dụng ArrayList:

````java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + "}";
    }
}

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Thêm sinh viên
        students.add(new Student("Alice", 101));
        students.add(new Student("Bob", 102));
        students.add(new Student("Charlie", 103));

        // In danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sắp xếp theo tên
        Collections.sort(students, Comparator.comparing(Student::getName));
        System.out.println("\nDanh sách sau khi sắp xếp theo tên:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Tìm kiếm sinh viên theo ID
        int searchId = 102;
        for (Student student : students) {
            if (student.getId() == searchId) {
                System.out.println("\nTìm thấy sinh viên có ID " + searchId + ": " + student);
                break;
            }
        }
    }
}
``````
```
## 5. Xử lý String

String là một lớp không thể thay đổi (immutable) trong Java, được sử dụng để lưu trữ và xử lý chuỗi ký tự.

### 5.1. Khởi tạo String

```java
String str1 = "Hello";  // Sử dụng literal
String str2 = new String("World");  // Sử dụng constructor
```

### 5.2. Các phương thức String quan trọng

```java
String str = "Hello, World!";

// Độ dài chuỗi
System.out.println(str.length());  // 13

// Chuyển đổi chữ hoa/thường
System.out.println(str.toUpperCase());  // HELLO, WORLD!
System.out.println(str.toLowerCase());  // hello, world!

// Cắt chuỗi
System.out.println(str.substring(0, 5));  // Hello
System.out.println(str.substring(7));  // World!

// Thay thế
System.out.println(str.replace("World", "Java"));  // Hello, Java!

// Tìm kiếm
System.out.println(str.indexOf("o"));  // 4
System.out.println(str.lastIndexOf("o"));  // 8

// Kiểm tra bắt đầu và kết thúc
System.out.println(str.startsWith("Hello"));  // true
System.out.println(str.endsWith("!"));  // true

// Loại bỏ khoảng trắng đầu và cuối
String paddedStr = "  Padded  ";
System.out.println(paddedStr.trim());  // "Padded"

// Tách chuỗi
String[] parts = str.split(", ");
for (String part : parts) {
    System.out.println(part);
}
// Output:
// Hello
// World!
```

### 5.3. Xử lý số liệu trong chuỗi

```java
String numStr = "123abc456";

// Loại bỏ ký tự không phải số
String numbersOnly = numStr.replaceAll("[^0-9]", "");
System.out.println(numbersOnly);  // 123456

// Tính tổng các số lẻ
int sum = 0;
for (char c : numbersOnly.toCharArray()) {
    int digit = Character.getNumericValue(c);
    if (digit % 2 != 0) {
        sum += digit;
    }
}
System.out.println("Tổng các số lẻ: " + sum);  // 9 (1 + 3 + 5)
```

### 5.4. Đếm nguyên âm và phụ âm

```java
String text = "Hello World";
int vowels = 0, consonants = 0;

text = text.toLowerCase();
for (int i = 0; i < text.length(); i++) {
    char ch = text.charAt(i);
    if (ch >= 'a' && ch <= 'z') {
        if ("aeiou".indexOf(ch) != -1) {
            vowels++;
        } else {
            consonants++;
        }
    }
}

System.out.println("Nguyên âm: " + vowels);  // 3
System.out.println("Phụ âm: " + consonants);  // 7
```

### 5.5. Đảo ngược chuỗi

```java
String original = "Hello World";

// Đảo ngược toàn bộ chuỗi
String reversed = new StringBuilder(original).reverse().toString();
System.out.println(reversed);  // dlroW olleH

// Đảo ngược từng từ
String[] words = original.split(" ");
StringBuilder reversedWords = new StringBuilder();
for (String word : words) {
    String reversedWord = new StringBuilder(word).reverse().toString();
    reversedWords.append(reversedWord).append(" ");
}
System.out.println(reversedWords.toString().trim());  // olleH dlroW
```

### 5.6. StringBuilder

StringBuilder là một lớp có thể thay đổi (mutable) được sử dụng để xử lý chuỗi hiệu quả hơn khi cần thực hiện nhiều thao tác.

```java
StringBuilder sb = new StringBuilder();

// Thêm chuỗi
sb.append("Hello");
sb.append(" ");
sb.append("World");

// Chèn chuỗi
sb.insert(5, ",");

// Xóa chuỗi
sb.delete(5, 6);

// Đảo ngược chuỗi
sb.reverse();

System.out.println(sb.toString());  // dlroW olleH

// So sánh hiệu suất
long startTime = System.nanoTime();

String result = "";
for (int i = 0; i < 10000; i++) {
    result += "a";
}

long endTime = System.nanoTime();
System.out.println("Thời gian với String: " + (endTime - startTime) + " ns");

startTime = System.nanoTime();

StringBuilder sbResult = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sbResult.append("a");
}

endTime = System.nanoTime();
System.out.println("Thời gian với StringBuilder: " + (endTime - startTime) + " ns");
```

### 5.7. Bài tập thực hành

1. Viết một phương thức để kiểm tra xem một chuỗi có phải là palindrome hay không (đọc xuôi ngược đều giống nhau, ví dụ: "radar").

<details>
<summary>Click vào để xem đáp án</summary>

```java
public static boolean isPalindrome(String str) {
    str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```
</details>

2. Viết một phương thức để đếm số từ trong một câu, bỏ qua khoảng trắng thừa.

<details>
<summary>Click vào để xem đáp án</summary>

```java
public static int countWords(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
        return 0;
    }
    String[] words = sentence.trim().split("\\s+");
    return words.length;
}
```
</details>

3. Viết một phương thức để mã hóa một chuỗi bằng cách dịch chuyển mỗi ký tự lên 3 vị trí trong bảng chữ cái (Caesar cipher).

<details>
<summary>Click vào để xem đáp án</summary>

```java
public static String caesarCipher(String str, int shift) {
    StringBuilder result = new StringBuilder();
    for (char character : str.toCharArray()) {
        if (Character.isLetter(character)) {
            char base = Character.isUpperCase(character) ? 'A' : 'a';
            result.append((char) ((character - base + shift) % 26 + base));
        } else {
            result.append(character);
        }
    }
    return result.toString();
}
```
</details>

Lưu ý: Khi làm việc với String, hãy luôn chú ý đến hiệu suất. Sử dụng StringBuilder khi cần thực hiện nhiều thao tác thay đổi chuỗi, và sử dụng String khi chỉ cần đọc hoặc so sánh chuỗi.

## 6. OOP (Object-Oriented Programming) trong Java

OOP là một phương pháp lập trình dựa trên khái niệm về "objects" (đối tượng), có thể chứa dữ liệu và mã.

### 6.1. Class và Object

Class là một bản thiết kế hoặc prototype từ đó các objects được tạo ra.

`````java
public class Car {
    // Thuộc tính (fields)
    private String brand;
    private int year;

    // Constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Phương thức (method)
    public void start() {
        System.out.println(brand + " is starting...");
    }

    // Getters và Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // ... (getters và setters cho year)
}

// Tạo object
Car myCar = new Car("Toyota", 2020);
myCar.start();
`````


Giải thích:
- `class Car`: Định nghĩa một lớp Car.
- `private String brand`: Thuộc tính private, chỉ có thể truy cập trong class.
- `public Car(String brand, int year)`: Constructor để khởi tạo object.
- `public void start()`: Phương thức public, có thể gọi từ bên ngoài class.
- `Car myCar = new Car("Toyota", 2020)`: Tạo một object Car mới.

### 6.2. Kế thừa (Inheritance)

Kế thừa cho phép một class kế thừa thuộc tính và phương thức từ một class khác.

`````java
public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, int year, int batteryCapacity) {
        super(brand, year);  // Gọi constructor của lớp cha
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void start() {
        System.out.println(getBrand() + " is starting silently...");
    }

    public void charge() {
        System.out.println("Charging the electric car...");
    }
}

ElectricCar myTesla = new ElectricCar("Tesla", 2023, 100);
myTesla.start();  // Sử dụng phương thức đã được override
myTesla.charge();  // Sử dụng phương thức mới
`````


Giải thích:
- `extends Car`: ElectricCar kế thừa từ Car.
- `super(brand, year)`: Gọi constructor của lớp cha.
- `@Override`: Chú thích cho biết phương thức này ghi đè phương thức của lớp cha.

### 6.3. Interface

Interface định nghĩa một bộ các phương thức abstract mà các class implement nó phải triển khai.

`````java
public interface Chargeable {
    void charge();
    default void displayChargeStatus() {
        System.out.println("Displaying charge status...");
    }
}

public class ElectricCar extends Car implements Chargeable {
    // ... (các thuộc tính và phương thức khác)

    @Override
    public void charge() {
        System.out.println("Charging the electric car...");
    }
}

Chargeable myChargeable = new ElectricCar("Tesla", 2023, 100);
myChargeable.charge();
myChargeable.displayChargeStatus();
`````


Giải thích:
- `interface Chargeable`: Định nghĩa một interface.
- `void charge();`: Phương thức abstract trong interface.
- `default void displayChargeStatus()`: Phương thức mặc định trong interface (từ Java 8).
- `implements Chargeable`: ElectricCar triển khai interface Chargeable.

### 6.4. Tính đa hình (Polymorphism)

Đa hình cho phép sử dụng các class con thông qua tham chiếu của class cha.

`````java
Car myCar = new ElectricCar("Tesla", 2023, 100);
myCar.start();  // Gọi phương thức start() của ElectricCar
`````


### 6.5. Encapsulation (Đóng gói)

Encapsulation là việc ẩn các chi tiết triển khai bên trong và chỉ hiển thị chức năng cho người dùng.

`````java
public class Car {
    private int speed;  // private field

    public void setSpeed(int speed) {
        if (speed >= 0 && speed <= 200) {
            this.speed = speed;
        } else {
            System.out.println("Invalid speed");
        }
    }

    public int getSpeed() {
        return speed;
    }
}
`````


Giải thích:
- `private int speed`: Thuộc tính private, không thể truy cập trực tiếp từ bên ngoài.
- `setSpeed()` và `getSpeed()`: Phương thức public để truy cập và thay đổi thuộc tính private.

### 6.6. Abstraction

Abstraction là quá trình ẩn các chi tiết triển khai phức tạp và chỉ hiển thị chức năng cần thiết.

`````java
public abstract class Vehicle {
    public abstract void move();

    public void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

public class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving on the road.");
    }
}
`````


Giải thích:
- `abstract class Vehicle`: Lớp trừu tượng, không thể tạo đối tượng trực tiếp.
- `public abstract void move();`: Phương thức trừu tượng, phải được triển khai bởi lớp con.

OOP trong Java cung cấp một cách mạnh mẽ để tổ chức và cấu trúc code, làm cho nó dễ bảo trì, mở rộng và tái sử dụng.

## 7. Exception Handling
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
} finally {
    System.out.println("This will always execute");
}
```

## 7. Exception Handling

Exception Handling là cơ chế xử lý các tình huống bất thường (ngoại lệ) có thể xảy ra trong quá trình thực thi chương trình.

### 7.1. Cấu trúc try-catch-finally

```java
try {
    // Khối code có thể gây ra ngoại lệ
    int result = 10 / 0;  // Ví dụ: chia cho 0 sẽ gây ra ArithmeticException
} catch (ArithmeticException e) {
    // Xử lý ngoại lệ cụ thể
    System.out.println("Lỗi: Không thể chia cho 0!");
    e.printStackTrace();  // In ra thông tin chi tiết về ngoại lệ
} catch (Exception e) {
    // Xử lý các ngoại lệ khác
    System.out.println("Đã xảy ra lỗi: " + e.getMessage());
} finally {
    // Khối code luôn được thực thi, bất kể có ngoại lệ hay không
    System.out.println("Khối finally luôn được thực thi");
}
```

Giải thích:
- `try`: Chứa code có thể gây ra ngoại lệ.
- `catch`: Bắt và xử lý các ngoại lệ cụ thể. Có thể có nhiều khối catch cho các loại ngoại lệ khác nhau.
- `finally`: Chứa code luôn được thực thi, dù có ngoại lệ hay không. Thường dùng để giải phóng tài nguyên.

### 7.2. Throws và Throw

```java
public void readFile(String filename) throws IOException {
    if (filename == null) {
        throw new IllegalArgumentException("Tên file không được null");
    }
    // Code đọc file
}
```

- `throws`: Khai báo rằng một phương thức có thể ném ra ngoại lệ.
- `throw`: Ném ra một ngoại lệ cụ thể.

### 7.3. Try-with-resources

```java
try (FileReader fr = new FileReader("file.txt");
     BufferedReader br = new BufferedReader(fr)) {
    // Đọc file
} catch (IOException e) {
    e.printStackTrace();
}
```

Try-with-resources tự động đóng các tài nguyên (như file, kết nối database) sau khi sử dụng.

## 8. File I/O (Input/Output)

File I/O trong Java cho phép đọc và ghi dữ liệu từ/vào các file.

### 8.1. Ghi file

```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Xin chào, đây là nội dung file!");
} catch (IOException e) {
    System.out.println("Lỗi khi ghi file: " + e.getMessage());
    e.printStackTrace();
}
```

Giải thích:
- `FileWriter`: Lớp dùng để ghi ký tự vào file.
- `write()`: Phương thức để ghi nội dung vào file.
- Try-with-resources đảm bảo file sẽ được đóng sau khi sử dụng.

### 8.2. Đọc file

```java
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    System.out.println("Lỗi khi đọc file: " + e.getMessage());
    e.printStackTrace();
}
```

Giải thích:
- `FileReader`: Lớp dùng để đọc ký tự từ file.
- `BufferedReader`: Lớp giúp đọc văn bản hiệu quả hơn bằng cách đệm các ký tự.
- `readLine()`: Đọc một dòng từ file.

### 8.3. Làm việc với thư mục

```java
File directory = new File("myDirectory");
if (!directory.exists()) {
    directory.mkdir();  // Tạo thư mục mới
}

File[] files = directory.listFiles();  // Liệt kê các file trong thư mục
for (File file : files) {
    System.out.println(file.getName());
}
```

- `File`: Lớp đại diện cho file và thư mục.
- `mkdir()`: Tạo thư mục mới.
- `listFiles()`: Lấy danh sách các file và thư mục con.

Lưu ý: Khi làm việc với File I/O, luôn xử lý các ngoại lệ có thể xảy ra và đóng tài nguyên sau khi sử dụng để tránh rò rỉ tài nguyên.

## 9. Collections Framework

Collections Framework trong Java cung cấp một kiến trúc để lưu trữ và thao tác với nhóm các đối tượng. Framework này bao gồm các interface, các lớp triển khai và các thuật toán.

### 9.1. List

List là một interface trong Collections Framework đại diện cho một danh sách có thứ tự các phần tử. Các phần tử trong List có thể truy cập bằng chỉ số và có thể chứa các phần tử trùng lặp.

```java
import java.util.*;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");

// Duyệt qua List bằng for-each loop
for (String fruit : list) {
    System.out.println(fruit);
}

// Truy cập phần tử bằng chỉ số
System.out.println(list.get(1));  // Banana

// Xóa phần tử
list.remove("Banana");

// Kiểm tra kích thước của List
System.out.println(list.size());  // 2
```

### 9.2. Set

Set là một interface đại diện cho một tập hợp không chứa các phần tử trùng lặp. Set không đảm bảo thứ tự các phần tử.

```java
Set<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
set.add(1);  // Phần tử trùng lặp, sẽ không được thêm vào

System.out.println(set.size());  // 2

// Kiểm tra sự tồn tại của phần tử
System.out.println(set.contains(1));  // true

// Xóa phần tử
set.remove(2);

// Duyệt qua Set
for (Integer num : set) {
    System.out.println(num);
}
```

### 9.3. Map

Map là một interface đại diện cho một cấu trúc dữ liệu lưu trữ các cặp key-value. Mỗi key trong Map là duy nhất.

```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 1);
map.put("Banana", 2);
map.put("Cherry", 3);

// Truy cập giá trị bằng key
System.out.println(map.get("Apple"));  // 1

// Kiểm tra sự tồn tại của key
System.out.println(map.containsKey("Banana"));  // true

// Duyệt qua Map
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Xóa cặp key-value
map.remove("Banana");
```

### 9.4. Collections Utility Class

Lớp `Collections` cung cấp các phương thức static để thao tác với các collection.

```java
List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));

// Sắp xếp List tăng dần
Collections.sort(numbers);
System.out.println(numbers);  // [1, 1, 2, 3, 4, 5, 5, 6, 9]

// Đảo ngược thứ tự các phần tử trong List
Collections.reverse(numbers);
System.out.println(numbers);  // [9, 6, 5, 5, 4, 3, 2, 1, 1]

// Hoán đổi vị trí của hai phần tử
Collections.swap(numbers, 0, 1);
System.out.println(numbers);  // [6, 9, 5, 5, 4, 3, 2, 1, 1]

// Tìm giá trị lớn nhất và nhỏ nhất
System.out.println(Collections.max(numbers));  // 9
System.out.println(Collections.min(numbers));  // 1

// Đếm số lần xuất hiện của một phần tử
System.out.println(Collections.frequency(numbers, 5));  // 2

// Tìm kiếm nhị phân (yêu cầu List đã được sắp xếp)
Collections.sort(numbers);
int index = Collections.binarySearch(numbers, 5);
System.out.println("Index of 5: " + index);
```

Lưu ý:
- Khi chọn cấu trúc dữ liệu, cân nhắc yêu cầu của bài toán:
  - Sử dụng List khi cần duy trì thứ tự chèn hoặc cho phép phần tử trùng lặp.
  - Sử dụng Set khi cần loại bỏ phần tử trùng lặp và không quan tâm đến thứ tự.
  - Sử dụng Map khi cần lưu trữ và truy xuất dữ liệu theo cặp key-value.
- Các phương thức của lớp Collections thường yêu cầu collection là mutable (có thể thay đổi). Đối với các immutable collection, cần tạo một bản sao mutable trước khi áp dụng các phương thức này.

## 10. Lambda Expressions (Java 8) (Sau này Lab211 cần)
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach(n -> System.out.println(n));

// Or even shorter
numbers.forEach(System.out::println);
```
# 11. Các kỹ thuật debug (NÊN HỌC)

1. Sử dụng `System.out.println()` để in giá trị biến
2. Sử dụng debugger của NetBeans để theo dõi giá trị biến theo thời gian thực
3. Kiểm tra logic của các câu lệnh điều kiện
4. Xác nhận các vòng lặp chạy đúng số lần mong muốn
5. Kiểm tra index khi làm việc với mảng và collections

## 12. Các lớp và phương thức tiện ích trong Java

Java cung cấp nhiều lớp và phương thức tiện ích để xử lý các kiểu dữ liệu cơ bản. Dưới đây là một số lớp quan trọng và các phương thức thường dùng của chúng:

### 12.1. Lớp Character

Lớp `Character` cung cấp các phương thức để làm việc với ký tự đơn.

```java
char ch = 'A';

// Kiểm tra xem ký tự có phải là số không
boolean isDigit = Character.isDigit(ch);  // false

// Kiểm tra xem ký tự có thuộc bảng chữ cái không
boolean isAlphabetic = Character.isAlphabetic(ch);  // true

// Kiểm tra xem ký tự có phải là chữ cái không
boolean isLetter = Character.isLetter(ch);  // true

// Kiểm tra xem ký tự có phải là chữ thường không
boolean isLowerCase = Character.isLowerCase(ch);  // false

// Kiểm tra xem ký tự có phải là chữ hoa không
boolean isUpperCase = Character.isUpperCase(ch);  // true

// Chuyển đổi ký tự thành chữ thường
char lowercase = Character.toLowerCase(ch);  // 'a'

// Chuyển đổi ký tự thành chữ hoa
char uppercase = Character.toUpperCase('b');  // 'B'
```

### 12.2. Lớp Integer

Lớp `Integer` cung cấp các phương thức để làm việc với số nguyên.

```java
String numStr = "123";
int num = 456;

// Chuyển đổi chuỗi thành số nguyên
int parsedInt = Integer.parseInt(numStr);  // 123

// Chuyển đổi số nguyên thành chuỗi
String intStr = Integer.toString(num);  // "456"

// Chuyển đổi số nguyên thành chuỗi nhị phân
String binaryStr = Integer.toBinaryString(num);  // "111001000"

// Chuyển đổi số nguyên thành chuỗi hex
String hexStr = Integer.toHexString(num);  // "1c8"

// Tìm giá trị lớn nhất giữa hai số
int max = Integer.max(10, 20);  // 20

// Tìm giá trị nhỏ nhất giữa hai số
int min = Integer.min(10, 20);  // 10
```

### 12.3. Lớp Double

Lớp `Double` cung cấp các phương thức để làm việc với số thực dấu phẩy động.

```java
String doubleStr = "3.14";
double num = 2.718;

// Chuyển đổi chuỗi thành số thực
double parsedDouble = Double.parseDouble(doubleStr);  // 3.14

// Chuyển đổi số thực thành chuỗi
String doubleString = Double.toString(num);  // "2.718"

// Kiểm tra xem một số có phải là NaN (Not a Number) không
boolean isNaN = Double.isNaN(num);  // false

// Kiểm tra xem một số có phải là vô cùng không
boolean isInfinite = Double.isInfinite(num);  // false

// So sánh hai số thực
int comparison = Double.compare(3.14, 2.718);  // 1 (3.14 > 2.718)
```

### 12.4. Lớp Math

Lớp `Math` cung cấp các phương thức toán học cơ bản.

```java
// Giá trị tuyệt đối
int absValue = Math.abs(-5);  // 5

// Làm tròn lên
double ceilValue = Math.ceil(3.1);  // 4.0

// Làm tròn xuống
double floorValue = Math.floor(3.9);  // 3.0

// Lũy thừa
double powerValue = Math.pow(2, 3);  // 8.0

// Căn bậc hai
double sqrtValue = Math.sqrt(9);  // 3.0

// Số ngẫu nhiên từ 0.0 đến 1.0
double randomValue = Math.random();
```

Lưu ý: Các lớp tiện ích này thường cung cấp phương thức static, có nghĩa là bạn có thể gọi chúng trực tiếp thông qua tên lớp mà không cần tạo đối tượng.



## 13. Copy - Paste các hàm tiện ích trong Java:

### Kiểm tra số nguyên tố
```java
public static boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

### Tính số Fibonacci thứ n
```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}
```

### Kiểm tra năm nhuận
```java
public static boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
```

### Tìm ước chung lớn nhất (UCLN)
```java
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```

### Tìm bội chung nhỏ nhất (BCNN)
```java
public static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}
```

### Kiểm tra chuỗi Palindrome
```java
public static boolean isPalindrome(String str) {
    str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    return str.equals(new StringBuilder(str).reverse().toString());
}
```

### Sắp xếp mảng tăng dần
```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
}
```

### Tìm phần tử lớn nhất trong mảng
```java
public static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++)
        if (arr[i] > max)
            max = arr[i];
    return max;
}
```

### Đếm số từ trong chuỗi
```java
public static int countWords(String str) {
    if (str == null || str.isEmpty()) return 0;
    return str.trim().split("\\s+").length;
}
```

### Chuyển đổi số thập phân sang nhị phân
```java
public static String decimalToBinary(int decimal) {
    return Integer.toBinaryString(decimal);
}
```

### Kiểm tra chuỗi có chứa chỉ số hay không
```java
public static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
}
```

### Tính giai thừa
```java
public static long factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

### Kiểm tra số Armstrong
```java
public static boolean isArmstrong(int number) {
    int originalNumber, remainder, result = 0, n = 0;
    originalNumber = number;
    for (;originalNumber != 0; originalNumber /= 10, ++n);
    originalNumber = number;
    for (;originalNumber != 0; originalNumber /= 10) {
        remainder = originalNumber % 10;
        result += Math.pow(remainder, n);
    }
    return result == number;
}
```

### Tìm phần tử xuất hiện nhiều nhất trong mảng
```java
public static int mostFrequent(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }
    int maxCount = 0, res = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (maxCount < entry.getValue()) {
            res = entry.getKey();
            maxCount = entry.getValue();
        }
    }
    return res;
}
```
## 14. Author 🖋️

<div align="center">

🌈🌟 Tài liệu này được biên soạn bởi **Minthep** 🌟🌈

</div>

Nếu bạn sử dụng tài liệu này, vui lòng:
- ✅ Ghi nhận nguồn 📝
- 🚨 Báo cáo bất kỳ vấn đề nào liên quan tới bản quyền tại [Facebook của tác giả](https://www.facebook.com/thepp.tan/) 🔗

<div align="center">

### ⚠️ Cảnh báo 🚧⚠️

</div>

> 📚🎓 Tài liệu này chỉ nhằm mục đích học tập và tham khảo. 🎓📚
> 
> 🚫🛑 Việc sử dụng tài liệu này buôn bán mà không xin phép chính chủ sẽ bị:
> - 🔴 Cảnh báo 🚨
> - 🔨 Ban khỏi mọi nền tảng của FPT và FUO 🚫

<div align="center">

### 🌟 Cảm ơn bạn đã sử dụng tài liệu này! 🙏🌟

</div>

