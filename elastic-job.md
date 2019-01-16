## elastic-job 运行机制

- 操作流程图:https://blog.csdn.net/jiequandao12/article/details/75575205

- 选举机制
    - Apache Curator 使用 Zookeeper 实现了两种分布式锁，LeaderLatch 是其中的一种。
    使用一个 Zookeeper 节点路径创建一个 LeaderLatch，#start() 后，
    调用 #await() 等待拿到这把锁。如果有多个线程执行了相同节点
    路径的 LeaderLatch 的 #await() 后，同一时刻有且仅有一个线程可以继续执行，
    其他线程需要等待。当该线程释放( LeaderLatch#close() )后，下一个线程可以拿到该锁继续执行;
    - 执行回调函数时,需要判断是否已经存在主节点,因为有锁,所以第一个拿到
    锁的线程已经产生主节点,如果没有这个判断,主节点会被覆盖;
    
- 当QuartzSchedulerThread线程执行JobRunShell线程时,Job实例实际为LiteJob,
这是elastic-job扩展的Job实例,在这里可以进行分片策略的设置;
