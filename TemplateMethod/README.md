## 模板方法模式（Template Method）

模板方法模式又叫做虚拟构造子模式或者多态性工厂模式

### 一、说明

定义了一个算法的骨架，而将一些步骤延迟到子类中，模版方法使得子类可以在不改变算法结构的情况下，重新定义算法的步骤。

### 二、角色

- 抽象类（Abstract Class）角色：

  负责给出一个算法的轮廓和骨架。它由一个模板方法和若干个基本方法构成。

  - 模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法；

  - 基本方法：是实现算法各个步骤的方法。

    基本方法又可以分为三种：

    - 抽象方法（Abstract Method）：一个抽象方法由抽象类声明、由其具 体子类实现；
    - 具体方法（Concrete Method）：一个具体方法由一个抽象类或具体类声明并实现，其子类可以进行覆盖也可以直接继承；
    - 钩子方法（Hook Method）：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。一般钩子方法是用于判断的逻辑方法，这类方法名一般为isXxx，返回值类型为boolean类型。

- 具体子类（Concrete Class）角色：

  实现抽象类中所定义的抽象方法和钩子方法，它们是抽象类中定义的算法的组成步骤。

### 三、总结

模板方法模式提高了代码的复用性，将相同部分的代码放在抽象的父类中，而将不同的代码放入不同的子类中，而且实现了反向控制，通过一个父类调用其子类的操作，通过对子类的具体实现扩展不同的行为，实现了反向控制 ，并符合“开闭原则”。但是对每个不同的实现都需要定义一个子类，这会导致类的个数增加，设计变的更加抽象。又因为是反向控制结构，所以提高了代码阅读的难度。

使用场景

1) 算法的整体步骤很固定，但其中个别部分容易变动，这时可以使用模板方法模式，将容易变动的部分抽象出来，让子类实现；
2) 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制。
