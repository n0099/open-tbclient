package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySdkServiceProxy;", "Lkotlin/Any;", "", "code", "", "msg", "", "onWxPayResult", "(ILjava/lang/String;)V", "", "uid", "Landroid/app/Activity;", "activity", "payload", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatProxyCallback;", "callback", "sendPay", "(JLandroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatProxyCallback;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface IWechatSdkServiceProxy extends IPaySdkServiceProxy {
    void onWxPayResult(int i2, String str);

    void sendPay(long j, Activity activity, String str, IWechatProxyCallback iWechatProxyCallback);
}
