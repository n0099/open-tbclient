package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.mobads.sdk.internal.cl;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPaySignMethod;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PaySignProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPaySignMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PaySignInfo;", "info", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPaySignCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestSign", "(Landroid/app/Activity;Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PaySignInfo;Lcom/yy/mobile/framework/revenuesdk/payapi/IPaySignCallback;)V", "", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignServiceProxy;", cl.c, "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignServiceProxy;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignServiceProxy;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class PaySignProxy extends DefaultPaySignMethod {
    public final String TAG = "PaySignProxy";
    public final IPaySignServiceProxy proxy;

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPaySignMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod
    public boolean isSupported(Activity activity) {
        return true;
    }

    public PaySignProxy(IPaySignServiceProxy iPaySignServiceProxy) {
        this.proxy = iPaySignServiceProxy;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPaySignMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod
    public void requestSign(Activity activity, PaySignInfo paySignInfo, final IPaySignCallback iPaySignCallback) {
        String str;
        RLog.info(this.TAG, "requestSign");
        if (activity == null) {
            RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
            if (iPaySignCallback != null) {
                iPaySignCallback.onPaySignFinish(-1, PayFailMsg.FAILED_PAY_SIGN);
                return;
            }
            return;
        }
        IPaySignServiceProxy iPaySignServiceProxy = this.proxy;
        String str2 = "";
        String str3 = (paySignInfo == null || (str3 = paySignInfo.scheme) == null) ? "" : "";
        if (paySignInfo != null && (str = paySignInfo.signParams) != null) {
            str2 = str;
        }
        iPaySignServiceProxy.requestSign(activity, str3, str2, new IPaySignProxyCallback() { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.PaySignProxy$requestSign$1
            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySignProxyCallback
            public void onFail(String str4) {
                String str5;
                str5 = PaySignProxy.this.TAG;
                RLog.error(str5, "requestSign fail failReason:" + str4, new Object[0]);
                IPaySignCallback iPaySignCallback2 = iPaySignCallback;
                if (iPaySignCallback2 != null) {
                    iPaySignCallback2.onPaySignFinish(-1, str4);
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySignProxyCallback
            public void onSuccess(String str4) {
                String str5;
                str5 = PaySignProxy.this.TAG;
                RLog.info(str5, "requestSign onSuccess result:" + str4);
                IPaySignCallback iPaySignCallback2 = iPaySignCallback;
                if (iPaySignCallback2 != null) {
                    iPaySignCallback2.onPaySignFinish(0, str4);
                }
            }
        });
    }
}
