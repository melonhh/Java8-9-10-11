# lambda
## lambda语法
可以把Lambda表达式理解为一种简洁的可传递匿名函数：
1. 没有名称
2. 有参数列表
3. 函数主体
4. 返回类型
5. 还有一个可以抛出的异常列表

## 函数式接口
```java
public interface Predicate<T> {
    boolean test(T t);
}
```
函数式接口就是只定义了一个抽象方法的接口（当然默认方法并不是抽象方法）。  

## 函数描述符
函数描述符：一种描述lambda和函数式接口的表示法。  
```
() -> void   // 表示参数为空，返回值为空，例如：Runnable

(Apple, Apple) -> int   // 参数为Apple，返回值为int，例如：Comparator<Apple>
``` 
函数式接口参数能够接受函数描述符一样的lambda表达式

## 使用函数式接口
* Predicate
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test (T t);
}
```

* Consumer
```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

* Function
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

* Supplier
```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```


### 基本类型特化
基本类型的自动装拆箱机制具有额外的性能代价。装箱基本类型从产量池进入堆内存，需要更多的内存。  


## 类型检查、类型推断以及限制
## 方法引用
三类方法引用：  
1. 指向静态方法的方法引用（Integer::parseInt)-----(String) -> Integer --- String 为参数
2. 指向实例的方法引用(String::length)-----(String) -> int --- 指向String实例的方法
3. 指向现存对象的方法引用(this::isValid)

### 构造函数的方法引用
```
Supplier<Apple> s1 = Apple::new;
Apple a = s1.get();
```
午餐构造函数

```
Function<Integer, Apple> f1 = Apple::new;
Apple a = f1.apply(100);
```
带一个参数的构造函数

```
BiFunction<Integer, String, Apple> f2 = Apple:new;
Apple a = f2.apply(100, "red");
```
带有两个参数的构造函数

```java
@FunctionalInterface
public interface AppleSupplier<Integer, String, String, Apple> {
    Apple product(Integer weight, String color, String type);
}
```
带有三个参数的构造函数，可以自定义函数式接口

