package com.xiaojukeji.know.streaming.km.collector.sink.kafka;

import com.didiglobal.logi.log.ILog;
import com.didiglobal.logi.log.LogFactory;
import com.xiaojukeji.know.streaming.km.collector.sink.AbstractMetricESSender;
import com.xiaojukeji.know.streaming.km.common.bean.event.metric.ReplicaMetricEvent;
import com.xiaojukeji.know.streaming.km.common.bean.po.metrice.ReplicationMetricPO;
import com.xiaojukeji.know.streaming.km.common.utils.ConvertUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.xiaojukeji.know.streaming.km.persistence.es.template.TemplateConstant.REPLICATION_INDEX;

@Component
public class ReplicaMetricESSender extends AbstractMetricESSender implements ApplicationListener<ReplicaMetricEvent> {
    private static final ILog  LOGGER = LogFactory.getLog(ReplicaMetricESSender.class);

    @PostConstruct
    public void init(){
        LOGGER.info("method=init||msg=init finished");
    }

    @Override
    public void onApplicationEvent(ReplicaMetricEvent event) {
        send2es(REPLICATION_INDEX, ConvertUtil.list2List(event.getReplicationMetrics(), ReplicationMetricPO.class));
    }
}
