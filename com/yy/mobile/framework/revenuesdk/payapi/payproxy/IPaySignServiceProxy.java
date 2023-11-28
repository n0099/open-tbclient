package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignServiceProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySdkServiceProxy;", "Lkotlin/Any;", "Landroid/app/Activity;", "activity", "", "scheme", "signParams", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignProxyCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestSign", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IPaySignProxyCallback;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IPaySignServiceProxy extends IPaySdkServiceProxy {
    void requestSign(Activity activity, String str, String str2, IPaySignProxyCallback iPaySignProxyCallback);
}
