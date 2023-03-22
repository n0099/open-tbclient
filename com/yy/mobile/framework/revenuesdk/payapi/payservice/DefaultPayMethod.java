package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJE\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "", "code", "", "msg", "", "onQQPayResult", "(ILjava/lang/String;)V", "onWxPayResult", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", WebChromeClient.KEY_ARG_CALLBACK, "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public class DefaultPayMethod implements IPayMethod {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DefaultPayMethod";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        RLog.warn(TAG, "isSupported be invoked but nothing could be done in DefaultPayMethod");
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onQQPayResult(int i, String str) {
        RLog.warn(TAG, "onQQPayResult be invoked but nothing could be done in DefaultPayMethod");
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i, String str) {
        RLog.warn(TAG, "onWxPayResult be invoked but nothing could be done in DefaultPayMethod");
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        RLog.warn(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        RLog.warn(TAG, "requestPay be invoked but nothing could be done in DefaultPayMethod");
        if (iPayCallback != null) {
            IPayMethod.Status status = IPayMethod.Status.ERROR;
            iPayCallback.onFail(status.code, status.message, null);
        }
    }
}
