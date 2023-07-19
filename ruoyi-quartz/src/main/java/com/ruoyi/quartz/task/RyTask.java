package com.ruoyi.quartz.task;

import com.ruoyi.system.domain.OrgOrderInfo;
import com.ruoyi.system.service.IOrgOrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.util.List;

/**
 * 定时任务调度测试
 *
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{

    @Autowired
    IOrgOrderInfoService orderInfoService;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        logger.info("订单回调定时任务开始");
        OrgOrderInfo orgOrderInfo = new OrgOrderInfo();
        orgOrderInfo.setCallbackStatus(0L);
        List<OrgOrderInfo> orgOrderInfoList = orderInfoService.selectPayorderStatusList(orgOrderInfo);
        if(orgOrderInfoList != null&& orgOrderInfoList.size()>0){
            for (OrgOrderInfo order:orgOrderInfoList) {
                orderInfoService.callbackOrder(order);
            }
        }
        logger.info("订单回调定时任务结束");
    }
}
