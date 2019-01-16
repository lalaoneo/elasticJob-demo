# elasticJob-demo
* [参考文档](https://blog.csdn.net/yangliuhbhd/article/details/80902212)
* 注意jobBean需要加入spring容器
* 需要引入文档的依赖,spring initializr没有这个依赖jar包,spring initializr只需要引入一个web就可以了
* jobName, jobParameter设置无效,因为ElasticJobAutoConfiguration并没有把值传给elasticJob
* [elasticJob运维平台](https://blog.csdn.net/lovelong8808/article/details/80393290)
