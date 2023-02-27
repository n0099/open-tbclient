package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
/* loaded from: classes9.dex */
public class H5PayParams {
    public Map<String, String> appClientExpand;
    public int appId;
    public IAppPayService appPayService;
    public int cid;
    public String orderId;
    public PayCallBackBean payBackBean;
    public String payChannel;
    public int payFlowTypeId;
    public String payMethod;
    public IPayServiceCallback payServiceCallback;
    public PayType payType;
    public int sid;
    public String token;
    public IToken tokenCallback;
    public String traceid = "";
    public long uid;
    public int usedChannel;
}
