package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySdkServiceProxy;", "Lkotlin/Any;", "", "uid", "Landroid/app/Activity;", "activity", "", "payload", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipayProxyCallback;", "callback", "", "sendPay", "(JLandroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipayProxyCallback;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IAlipaySdkServiceProxy extends IPaySdkServiceProxy {
    void sendPay(long j2, Activity activity, String str, IAlipayProxyCallback iAlipayProxyCallback);
}
