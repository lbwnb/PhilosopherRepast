# PhilosopherRepast
哲学家就餐问题(java多线程的理解)



在使用java中的sychronized或者显示锁来进行互斥操作时，就可能会出现死锁的情况：即任务一获得A资源，等待B资源。任务二获得B资源等待C资源。任务三获得C资源等待D资源。而任务四获得D资源等待A资源，这样就造成一个连续的循环等待，没有哪个线程能够继续下去，称为死锁。 
对于死锁，哲学家就餐问题就是一个经典的例子。


问题描述[1]： 
在一个圆桌上，有n个哲学家，n只筷子，每个哲学家左右两边各返一只筷子。哲学家可以进行思考和吃饭，思考时，不获取筷子。吃饭时，必须同时获得左右两只筷子才能吃饭（先获得右边，再获得左边）。

解决方法：
服务生解法
资源分级解法
Chandy/Misra解法
