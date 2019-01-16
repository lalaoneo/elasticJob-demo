package com.lori.elasticJobdemo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * jobName, jobParameter设置无效,因为ElasticJobAutoConfiguration并没有把值传给elasticJob
 */
@ElasticSimpleJob(cron = "0/5 * * * * ?",shardingTotalCount = 3,shardingItemParameters = "0=A,1=B,2=C")
@Component
public class MySimpleJob implements SimpleJob {

    private Logger logger = LoggerFactory.getLogger(MySimpleJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {

        logger.info("Thread ID: {},任务总片数: {},当前分片项: {},当前参数: {},当前任务名称: {}",
                Thread.currentThread().getId(),shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),shardingContext.getShardingParameter(),
                shardingContext.getJobName());
    }
}
