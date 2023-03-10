## 抽象工厂模式（Abstract Factory ）

抽象工厂模式又称为Kit模式

### 一、说明

抽象工厂模式是一种对象创建型模式。为创建一组对象提供了一种解决方案，提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。用于产品族的构建。抽象工厂是所有形态的工厂模式中最为抽象和最具一般性的一种形态。抽象工厂是指当有多个抽象角色时使用的一种工厂模式。抽象工厂模式可以向客户端提供一个接口，使客户端在不必指定产品的具体情况下，创建多个产品族中的产品对象。

在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于产生多种不同类型的产品，这些产品构成了一个产品族。

### 二、角色

- 抽象工厂（Abstract Factory）角色：

  它声明了一组用于创建一族产品的方法，每一个方法对应一种产品。

- 具体工厂（Concrete Factory）角色：

  实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。这个角色直接在客户端的调用下创建产品的实例，并含有选择合适的产品对象的逻辑，而这个逻辑是与应用系统的商业逻辑紧密相关的。 

- 抽象产品（Abstract Product）角色：

  为每种产品对象的抽象，可以是接口或抽象类，在抽象产品中声明了产品所具有的业务方法。

- 具体产品（Concrete Product）角色：

  定义具体工厂生产的具体产品对象，实现抽象产品色色中声明的方法

UML图如下：

![ab4037bf07a996cb05ce448077d59c4c.png](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/ab4037bf07a996cb05ce448077d59c4c.png)

### 三、代码说明

#### 1、UML

![image-20230130101709836](https://raw.githubusercontent.com/xiaolifeizei/myImages/master/picgo/image-20230130101709836.png)

#### 2、核心代码

SubjectFactory是抽象工厂角色，声明了两个方法来创建两种类型的产品

```java
public interface SubjectFactory {
    SubjectFirst getSubjectFirst(String type);
    SubjectSecond getSubjectSecond(String type);
}
```

SubjectCategoryAFactory和SubjectCategoryBFactory是具体工厂角色都实现了SubjectFactory接口

```java
public class SubjectCategoryAFactory implements SubjectFactory {
    @Override
    public SubjectFirst getSubjectFirst(String type) {
        if ("one".equals(type)) {
            return new SubjectFirstOneImpl();
        }
        if ("two".equals(type)) {
            return new SubjectFirstTwoImpl();
        }
        return null;
    }

    @Override
    public SubjectSecond getSubjectSecond(String type) {
        if ("one".equals(type)) {
            return new SubjectSecondOneImpl();
        }
        if ("two".equals(type)) {
            return new SubjectSecondTwoImpl();
        }
        return null;
    }
}

public class SubjectCategoryBFactory implements SubjectFactory{
    @Override
    public SubjectFirst getSubjectFirst(String type) {
        if ("one".equals(type)) {
            return new SubjectFirstOneImpl();
        }

        if ("two".equals(type)) {
            return new SubjectFirstTwoImpl();
        }
        return null;
    }
    @Override
    public SubjectSecond getSubjectSecond(String type) {
        if ("one".equals(type)) {
            return new SubjectSecondOneImpl();
        }

        if ("two".equals(type)) {
            return new SubjectSecondTwoImpl();
        }
        return null;
    }
}
```

SubjectFirst和SubjectSeconed是抽象产品角色，定义了两种类型的产品

```java
public interface SubjectFirst {
    void request();
}

public interface SubjectSecond {
    void request();
}
```

### 四、总结

工厂模式中的每一个形态都是针对一定问题的解决方案，工厂方法针对的是多个产品系列结构；而抽象工厂模式针对的是多个产品族结构，一个产品族内有多个产品系列。