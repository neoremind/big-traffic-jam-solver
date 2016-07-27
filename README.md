# 大塞车游戏的算法解

原创博文地址[请点击这里](http://neoremind.com/2016/07/%E5%A4%A7%E5%A1%9E%E8%BD%A6%E6%B8%B8%E6%88%8F%E6%B4%BB%E5%8A%A8%E7%9A%84
%E7%AE%97%E6%B3%95%E8%A7%A3/)，下面基本是原文。

最近在公司组织的培训上，遇到了一个很有意思的算法题，这篇文章就借这个为题提供一个解。

首先感谢李培英老师，《职业化研讨》这门课非常值得公司内的一线管理人员去学习。在讲到职业化内涵里的“规则意识”一节时，让大家做了一个简单的大塞车游戏，规则如下：

1、邀请16名以上的学员（注意是偶数），列成两队，面对面的坐在椅子上。

2、中间叫做“鸿沟”，是不允许越过的。

3、在“鸿沟”的一端，有一把空椅子，暂且把靠近这一端的队叫做队头。

4、要求两队只能通过空椅子这条路来交换位置，自己只允许两种行动方式，第一往前走一步，第二可以隔着对方跳一步。

例如，分为A，B两队，初始状态如下：
```
A8 | A7 | A6 | A5 | A4 | A3 | A2 | A1 |
--------------------------------------
                鸿沟              |   |
--------------------------------------
B8 | B7 | B6 | B5 | B4 | B3 | B2 | B1 |
```

那么第一步只有一种一种选择，A1或者B1有一个人去空位，然后下面的继续，按照规则，最终要达到这种最终状态：
```
B8 | B7 | B6 | B5 | B4 | B3 | B2 | B1 |
--------------------------------------
                鸿沟              |   |
--------------------------------------
A8 | A7 | A6 | A5 | A4 | A3 | A2 | A1 |
```

可以走的规则如下，出现下面的两种情况A4可以行动，要么走要么跳，也就是走或者跳到空格，否则A4是动不了的。
```
| A4 |    | A3|

| A4 | B3 |   | A3
```

有兴趣的读者可以自己组织一些同学试试，会非常容易陷入迷茫的，走不下去了。当然不排除聪明的学员们能够很快的解决:-)

这道题老师想表达的是规则一部分是看得见的客观存在，另外一大部分是看不见的，总结其规律往往较为困难，但是我们应用尊重规则，这里面的道理可能很多人看不到，但是他是简单有效的，anyway，圆规正传，本文是解题：

如果你让1万人做这个游戏，你怎么用通过的语言告诉每一个人，让他们怎么行动？

我总结的规律如下：
* 1、任意一方先行动，做到空椅子，行动权转移到另一方。
* 2、如果前面是对方，则跳过去。
* 3、如果前面的前面是对方，或者前面全是自己人，或者前面就是终点了，则“贪婪地”往前走一步。
* 4、如果前面的前面是自己人，就别动了，交换行动权到对方的队头。

按照这种规则，我的算法放到了github上，具体演示见下面的gif图。

每队1人：

![](http://neoremind.com/wp-content/uploads/elem3.gif)

每队2人：

![](http://neoremind.com/wp-content/uploads/elem5.gif)

每队3人：

![](http://neoremind.com/wp-content/uploads/elem7.gif)

每队4人：

![](http://neoremind.com/wp-content/uploads/elem9.gif)

每队5人：

![](http://neoremind.com/wp-content/uploads/elem11.gif)

这道题目，重点在于总结这个行动的规则，并且用算法描述实现，大言不惭的说可以post到leetcode上了，看谁能解了，我的解法不一定最好，边界条件的判断非常多，需要小心处理。

算法入口如下：
```
new BigTrafficJam(17).solve();
//new BigTrafficJam(17).setPrintOutIntervalMs(1200).solve();
```

最后，还是回到《职业化研讨》这门课上，体会最深的一句管理的话就是“管理就是激发人善意的潜能”。
