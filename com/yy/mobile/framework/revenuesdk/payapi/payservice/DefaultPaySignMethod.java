package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPaySignMethod;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayAliSignMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "activity", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PaySignInfo;", "info", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPaySignCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "requestSign", "(Landroid/app/Activity;Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PaySignInfo;Lcom/yy/mobile/framework/revenuesdk/payapi/IPaySignCallback;)V", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class DefaultPaySignMethod implements IPayAliSignMethod {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DefaultPaySignMethod";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPaySignMethod$Companion;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod
    public boolean isSupported(Activity activity) {
        RLog.warn(TAG, "isSupported be invoked but nothing could be done in DefaultPaySignMethod");
        return false;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod
    public void requestSign(Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback) {
        RLog.warn(TAG, "requestSign be invoked but nothing could be done in DefaultPaySignMethod");
    }
}
