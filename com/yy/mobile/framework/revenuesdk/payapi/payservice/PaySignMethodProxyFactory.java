package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySignServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.PaySignProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PaySignMethodProxyFactory {
    public final String TAG = "PaySignMethodProxyFactory";
    public Map<String, IPaySdkServiceProxy> payMethodProxyMap = new HashMap(5);

    /* loaded from: classes2.dex */
    public static class Holder {
        public static final PaySignMethodProxyFactory instance = new PaySignMethodProxyFactory();
    }

    public static PaySignMethodProxyFactory instance() {
        return Holder.instance;
    }

    public synchronized void addPayServiceProxyMap(PayType payType, IPaySdkServiceProxy iPaySdkServiceProxy) {
        if (this.payMethodProxyMap.containsKey(payType.getChannel())) {
            RLog.info("PaySignMethodProxyFactory", "addPayMethodProxyMap but contains paychannel:" + payType.getChannel());
            return;
        }
        RLog.info("PaySignMethodProxyFactory", "addPayMethodProxyMap paychannel:" + payType.getChannel());
        this.payMethodProxyMap.put(payType.getChannel(), iPaySdkServiceProxy);
    }

    public synchronized IPayAliSignMethod findProxyPayMethod(PayType payType) {
        IPaySdkServiceProxy findProxyPayService = findProxyPayService(payType);
        if (findProxyPayService == null) {
            RLog.info("PaySignMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        } else if (payType != PayType.ALI_PAY_SIGN) {
            return null;
        } else {
            if (findProxyPayService instanceof IPaySignServiceProxy) {
                return new PaySignProxy((IPaySignServiceProxy) findProxyPayService);
            }
            RLog.error("PaySignMethodProxyFactory", "paySdkServiceProxy is not IAlipaySdkProxy ", new Object[0]);
            return null;
        }
    }

    public synchronized IPaySdkServiceProxy findProxyPayService(PayType payType) {
        IPaySdkServiceProxy iPaySdkServiceProxy = this.payMethodProxyMap.get(payType.getChannel());
        if (iPaySdkServiceProxy == null) {
            RLog.info("PaySignMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        }
        return iPaySdkServiceProxy;
    }

    public String getProxyMapKey(int i, int i2, String str) {
        return i + "-" + i2 + "-" + str;
    }

    public synchronized void removePayServiceProxyMap(PayType payType) {
        if (!this.payMethodProxyMap.containsKey(payType.getChannel())) {
            RLog.info("PaySignMethodProxyFactory", "removePayMethodProxyMap but not contains paychannel:" + payType.getChannel());
            return;
        }
        RLog.info("PaySignMethodProxyFactory", "removePayMethodProxyMap paychannel:" + payType.getChannel());
        this.payMethodProxyMap.remove(payType.getChannel());
    }
}
