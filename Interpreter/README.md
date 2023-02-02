## 解释器模式（Interpreter）

解释器模式

### 一、说明

解释器模式属于行为型模式，提供了一种评估计算语言语法或表达式的方法。给定一个**语言**，定义它的**文法**的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。

​	语言：使用规定格式和文法的一类字符组合

​	文法，简单说就是“语法规则”

例如Java定义变量：

​	文法：[public|protected|private] + [static] + [final] + 变量类型 + 变量名 + [= 初始值] + 分号

​	语言：private static final String name = "hello";

模式的本质与设计意图：

- 模式本质：分离实现，解释执行

- 设计意图：为语言中不同的文法表示，分别定义一个与该文法表示相对应的解释器，然后通过这个解释器来对该文法表示进行解释 

### 二、角色

- 抽象表达式（Abstract Expression）角色：

  约定解释器的解释操作，主要是一个interpret()方法

- 终结符表达式（Terminal Expression）角色：

  抽象表达式角色的具体实现类。实现文法中和终结符相关的解释操作，不再包含其它的解释器，如果用组合模式来构建抽象语法树的话，就相当于组合模式中的叶子角色（Leaf），可以有多种终结符解释器。

- 非终结符表达式（Nonterminal Expression）角色：

  抽象表达式角色的具体实现类。实现文法中和非终结符相关的解释操作，通常一个解释器对应一个语法规则，可以包含其它的解释器，如果用组合模式来构建抽象语法树的话，就相当于组合模式中的树枝角色（Composite），可以有多种非终结符解释器

- 环境（Context）角色：

  也叫上下文，常用Hash Map来代替，通常包含解释器之外的一些全局信息（解释器需要的数据，或是公共的功能）。

- 客户端（Client）角色：

  构建文法表示的抽象语法树（Abstract Syntax Tree，该抽象语法树由终结符表达式和非终结符表达式的实例装配而成），并调用解释操作interpret()方法

### 三、相关模式

1. 解释器和组合模式

   通常解释器模式都会使用组合模式来实现，这样能够方便地构建抽象语法树。一般非终结符解释器相当于组合模式中的组合对象，终结符解释器相当于叶子对象。

2. 解释器模式和迭代器模式

   由于解释器模式通常使用组合模式来实现，因此在遍历整个对象结构时，可以使用迭代器模式。

3. 解释器模式和享元模式

   在使用解释器模式的时候，可能会造成多个细粒度对象，如各式各样的终结符解释器，而这些终结符解释器对不同的表达式来说是一样的，是可以共用的，因此可以引入享元模式来共享这些对象。

4. 解释器模式和访问者模式

   在解释器模式中，语法规则和解释器对象是有对应关系的。语法规则的变动意味着功能的变化。自然会导致使用不同的解释器对象；而且一个语法规则可以被不同的解释器解释执行。因此在构建抽象语法树的时候，如果每个节点所对应的解释器对象是固定的，这意味着该节点对应的功能是固定的，那么就不得不根据需要来构建不同的抽象语法树。为了让构建的抽象语法树较为通用，那就要求解释器的功能不要那么固定，要能很方便地改变解释器的功能，这个时候就变成了如何能够很方便地更改树形结构中节点对象的功能了，访问者模式可以很好的实现这个功能。 

### 四、总结

解释器模式的结构与组合模式相似，不过其包含的组成元素比组合模式多，而且组合模式是对象结构型模式，而解释器模式是类行为型模式。解释器模式在实际的软件开发中使用比较少，因为它会引起效率、性能以及维护等问题。在Jdk中的正则表达式中的Pattern类和Spring里面的Expression Parse接口使用的是解释器模式的思想。一个语言需要解释执行，且语言中的句子可以表示为一个抽象语法树的时候，如 XML 文档解释等可以使用解释器模式。整体来说还是一种应用较少的设计模式。

应用场景：

1. 应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树

2. 一些重复出现的问题可以用一种简单的语言来表达

3. 一个简单语法需要解释的场景，比如编译器、运算表达式计算、正则表达式等

   在项目开发中，如果要对数据表达式进行分析与计算，无须再用解释器模式进行设计了，Java 提供了以下强大的数学公式解析器：Expression4J、MESP(Math Expression String Parser) 和**Jep（ Java expression parser ）**等，它们可以解释一些复杂的文法，功能强大，使用简单。也可以用SpringEL实现

解释器模式有以下优点:

1. 易于实现语法 

   一条语法规则用一个解释器对象来解释执行。对于解释器的实现来讲，功能就变得比较简单，只需要考虑这一条语法规则的实现就可以了，其他的都不用管。

2. 易于扩展新的语法

   正是由于采用一个解释器对象负责一条语法规则的方式，使得扩展新的语法非常容易。扩展了新的语法，只需要创建相应的解释器对象，在创建抽象语法树的时候使用这个新的解释器对象就可以了。

解释器模式有以下缺点:

1) 不适合复杂的语法

​      如果语法特别复杂，构建解释器模式需要的抽象语法树的工作是非常艰巨的，再加上有可能会需要构建多个抽象语法树。所以解释器模式不太适合于复杂的语法，对于复杂的语法，使用**语法分析程序**或**编译器生成器**可能会更好一些。 