package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.WechatPayProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class PayMethodProxyFactory {
    public final String TAG = "PayMethodProxyFactory";
    public Map<String, IPaySdkServiceProxy> payMethodProxyMap = new HashMap(5);

    /* loaded from: classes9.dex */
    public static class Holder {
        public static final PayMethodProxyFactory instance = new PayMethodProxyFactory();
    }

    public static PayMethodProxyFactory instance() {
        return Holder.instance;
    }

    public synchronized void addPayServiceProxyMap(PayType payType, IPaySdkServiceProxy iPaySdkServiceProxy) {
        if (this.payMethodProxyMap.containsKey(payType.getChannel())) {
            RLog.info("PayMethodProxyFactory", "addPayMethodProxyMap but contains paychannel:" + payType.getChannel());
            return;
        }
        RLog.info("PayMethodProxyFactory", "addPayMethodProxyMap paychannel:" + payType.getChannel());
        this.payMethodProxyMap.put(payType.getChannel(), iPaySdkServiceProxy);
    }

    public synchronized IPayMethod findProxyPayMethod(PayType payType) {
        IPaySdkServiceProxy findProxyPayService = findProxyPayService(payType);
        if (findProxyPayService == null) {
            RLog.info("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        } else if (payType == PayType.ALI_PAY) {
            if (findProxyPayService instanceof IAlipaySdkServiceProxy) {
                return new AlipayProxy((IAlipaySdkServiceProxy) findProxyPayService);
            }
            RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IAlipaySdkProxy ", new Object[0]);
            return null;
        } else if (payType == PayType.WECHAT_PAY) {
            if (findProxyPayService instanceof IWechatSdkServiceProxy) {
                return new WechatPayProxy((IWechatSdkServiceProxy) findProxyPayService);
            }
            RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IWechatSdkProxy ", new Object[0]);
            return null;
        } else if (payType != PayType.DXM_PAY) {
            return null;
        } else {
            if (findProxyPayService instanceof IDxmSdkServiceProxy) {
                return new DxmPayProxy((IDxmSdkServiceProxy) findProxyPayService);
            }
            RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IDxmSdkServiceProxy ", new Object[0]);
            return null;
        }
    }

    public synchronized IPaySdkServiceProxy findProxyPayService(PayType payType) {
        IPaySdkServiceProxy iPaySdkServiceProxy = this.payMethodProxyMap.get(payType.getChannel());
        if (iPaySdkServiceProxy == null) {
            RLog.info("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        }
        return iPaySdkServiceProxy;
    }

    public String getProxyMapKey(int i, int i2, String str) {
        return i + "-" + i2 + "-" + str;
    }

    public synchronized void removePayServiceProxyMap(PayType payType) {
        if (!this.payMethodProxyMap.containsKey(payType.getChannel())) {
            RLog.info("PayMethodProxyFactory", "removePayMethodProxyMap but not contains paychannel:" + payType.getChannel());
            return;
        }
        RLog.info("PayMethodProxyFactory", "removePayMethodProxyMap paychannel:" + payType.getChannel());
        this.payMethodProxyMap.remove(payType.getChannel());
    }
}
