package com.ruoyi.system.service;

import com.alipay.api.AlipayApiException;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.OrgOrderInfo;
import com.ruoyi.system.domain.SysAlipayConfig;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface AlipayServer {

    AjaxResult aliPayment(OrgOrderInfo orderInfo);

    String aliPaymentReString(OrgOrderInfo orderInfo);

    public String aliPayCallback(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;

    public String queryOrder(OrgOrderInfo orderInfo, SysAlipayConfig alipayCnf) throws AlipayApiException;
    String refund(OrgOrderInfo orderInfo);
    String refundQuery(OrgOrderInfo orderInfo);

    /**
     * 定时同步查询交易投诉列表
     */
    int synctradecomplain();

    String aliPayTradecomplainChanged(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;

}
