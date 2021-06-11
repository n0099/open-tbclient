package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
/* loaded from: classes7.dex */
public class H5PayParams {
    public IAppPayService appPayService;
    public String orderId;
    public PayCallBackBean payBackBean;
    public IPayCallback payCallback;
    public IPayInnerLogic payInnerLogic;
    public ChargeCurrencyReqParams reqParams;
}
