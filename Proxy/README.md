## 代理模式（Proxy）

代理模式

### 一、说明

代理模式就是客户端不再直接和具体的类打交道, 而是通过一个中间层来访问这个具体的类，**在不修改原目标对象的前提下，提供额外的功能操作，扩展目标对象的功能。**这个中间层就是代理。

当一个对象不想或者不能直接引用另一个对象时，代理对象可以在客户端和目标对象之间起到中介的作用。

### 二、角色

- 抽象目标（Subject）角色

  定义 Real Subject 和 Proxy 角色都应该实现的接口，可以没有

- 目标（Real Subject）角色

  目标类，也就是被代理类、委托类。用来真正完成业务服务功能的类

- 代理（Proxy）角色

  将自身的请求用目标角色对应的功能来实现，代理类并不真正的去实现其业务功能只对功能进行增强或控制访问

### 三、总结

代理模式的作用主要有两个，一是进行功能增强，即在原有功能的基础上添加额外的功能，二是控制访问，通过代理类对客户端的访问进行权限控制。

代理模式分为两大类：静态代理和动态代理

- 静态代理

  - 组合式

    被代理对象作为代理类的成员变量

  - 继承式

    代理类继承被代理对象

- 动态代理

  - JDK动态代理

    基于 Java 反射机制实现，必须要实现了接口的业务类才能用这种方法生成代理对象，代码实现简单

  - cglib动态代理

    基于 ASM 框架通过生成业务类的子类来实现，无须实现接口，代理类无侵入

  - AOP动态代理

    使用Spring的AOP机制实现

    

静态代理与动态代理的主要区别在于：

- 静态代理在编译时已经实现，编译后会生成对应的实际的class文件
- 动态代理是在运行时产生的，是在运行时动态的生成类字节码，并加载到JVM中
