## 装饰者模式（Wrapper）

装饰者模式又叫做包装模式

### 一、说明

动态的将新功能附加到对象上，在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则。允许通过将对象放入包含行为的特殊封装对象中来为原对象绑定新的行为。

### 二、角色

- 抽象构件（Component）角色 

  被装饰对象的基类，定义一个抽象接口以规范准备接收附加责任的对象。

- 具体构件（Concrete Component）角色 

  具体被装饰的对象，实现抽象构件，装饰角色（Decorator）可为其添加职责

- 抽象装饰（Decorator）角色 

  持有具体构件（Concrete Component）的实例，并且继承或实现抽象构件（Component），通过其子类扩展具体构件的功能

- 具体装饰（Concrete Decorator）角色 

  实现抽象装饰的相关方法，并给具体构件对象（Concrete Component）添加职责。

### 三、总结

装饰者模式的要求客户端程序不要声明一个具体构件（Concrete Component）类型的变量，而应当声明一个抽象构件（Component）类型的变量（完全透明）。装饰模式的用意是在不改变接口的前提下，增强所装饰的类的功能，但在增强功能的时候，往往需要建立新的公开的方法，然而允许装饰模式改变接口、增加新的方法就是说客户端**可以声明具体构件（Concrete Component）类型的变量，从而可以调用具体构件（Concrete Component）类中才拥有的特有方法**，这就意味着大多数的装饰模式的实现都是**半透明**的，而不是**完全透明**的。半透明的装饰模式是介于装饰模式和适配器模式之间的。在适配器模式里，适配器类的接口通常会与目标类的接口重叠，但往往并不完全相同。换言之，适配器类的接口会比被装饰的目标类接口宽。因此大多数的装饰模式实际上是半透明的装饰模式，这样的装饰模式也称做半装饰、半适配器模式。

使用场景：

1) 希望在不修改代码的情况下使用对象，并且希望在运行时为对象新增额外的行为

2) 如果用继承来扩展对象行为的方案难以实现或者不可行时，可以尝试使用该模式