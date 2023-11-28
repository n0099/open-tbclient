package com.yy.mobile.framework.revenuesdk.payapi.request;

import android.app.Activity;
import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\bN\u0010OJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R0\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010'R\"\u0010+\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R$\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010'R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010$\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010'R\"\u0010;\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R$\u0010>\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010$\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010'R\"\u0010A\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R\"\u0010E\u001a\u00020D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0011\u001a\u0004\bL\u0010\u0013\"\u0004\bM\u0010\u0015¨\u0006Q"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "", "toString", "()Ljava/lang/String;", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", "cid", "I", "getCid", "()I", "setCid", "(I)V", "Ljava/lang/ref/WeakReference;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "getContextWeakRef", "()Ljava/lang/ref/WeakReference;", "setContextWeakRef", "(Ljava/lang/ref/WeakReference;)V", "currencyType", "getCurrencyType", "setCurrencyType", "from", "getFrom", "setFrom", "oldProductId", "Ljava/lang/String;", "getOldProductId", "setOldProductId", "(Ljava/lang/String;)V", "payChannel", "getPayChannel", "setPayChannel", "payFlowTypeId", "getPayFlowTypeId", "setPayFlowTypeId", "payMethod", "getPayMethod", "setPayMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", "productId", "getProductId", "setProductId", "prorationMode", "getProrationMode", "setProrationMode", "returnUrl", "getReturnUrl", "setReturnUrl", "sid", "getSid", "setSid", "", "srcAmount", "D", "getSrcAmount", "()D", "setSrcAmount", "(D)V", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ChargeCurrencyReqParams extends RequestParams {
    public static final Companion Companion = new Companion(null);
    public Map<String, String> appClientExpand;
    public int cid;
    public WeakReference<Activity> contextWeakRef;
    public int currencyType;
    public int from;
    public String oldProductId = "";
    public String payChannel;
    public int payFlowTypeId;
    public String payMethod;
    public PayType payType;
    public String productId;
    public int prorationMode;
    public String returnUrl;
    public int sid;
    public double srcAmount;
    public int subscriptionType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams$Companion;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "other", "clone", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;)Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChargeCurrencyReqParams clone(ChargeCurrencyReqParams chargeCurrencyReqParams) {
            ChargeCurrencyReqParams chargeCurrencyReqParams2 = new ChargeCurrencyReqParams();
            chargeCurrencyReqParams2.clone(chargeCurrencyReqParams);
            chargeCurrencyReqParams2.setContextWeakRef(chargeCurrencyReqParams.getContextWeakRef());
            return chargeCurrencyReqParams2;
        }
    }

    public final Map<String, String> getAppClientExpand() {
        return this.appClientExpand;
    }

    public final int getCid() {
        return this.cid;
    }

    public final Activity getContext() {
        WeakReference<Activity> weakReference = this.contextWeakRef;
        if (weakReference != null) {
            if (weakReference == null) {
                Intrinsics.throwNpe();
            }
            return weakReference.get();
        }
        return null;
    }

    public final WeakReference<Activity> getContextWeakRef() {
        return this.contextWeakRef;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final int getFrom() {
        return this.from;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final String getPayChannel() {
        return this.payChannel;
    }

    public final int getPayFlowTypeId() {
        return this.payFlowTypeId;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final PayType getPayType() {
        return this.payType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getProrationMode() {
        return this.prorationMode;
    }

    public final String getReturnUrl() {
        return this.returnUrl;
    }

    public final int getSid() {
        return this.sid;
    }

    public final double getSrcAmount() {
        return this.srcAmount;
    }

    public final int getSubscriptionType() {
        return this.subscriptionType;
    }

    public final void setAppClientExpand(Map<String, String> map) {
        this.appClientExpand = map;
    }

    public final void setCid(int i) {
        this.cid = i;
    }

    public final void setContextWeakRef(WeakReference<Activity> weakReference) {
        this.contextWeakRef = weakReference;
    }

    public final void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    public final void setOldProductId(String str) {
        this.oldProductId = str;
    }

    public final void setPayChannel(String str) {
        this.payChannel = str;
    }

    public final void setPayFlowTypeId(int i) {
        this.payFlowTypeId = i;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final void setPayType(PayType payType) {
        this.payType = payType;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final void setProrationMode(int i) {
        this.prorationMode = i;
    }

    public final void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public final void setSid(int i) {
        this.sid = i;
    }

    public final void setSrcAmount(double d) {
        this.srcAmount = d;
    }

    public final void setSubscriptionType(int i) {
        this.subscriptionType = i;
    }

    public String toString() {
        return "ChargeCurrencyReqParams{cmd=" + getCmd() + ", appId=" + getAppId() + ", clientVersion =" + getClientVersion() + ",requestTime = " + getRequestTime() + ", clientVersion =" + getClientVersion() + ", retryCount =" + getRetryCount() + ", intervalMs =" + getIntervalMs() + ", retryType =" + getRetryType() + ", timeOutMs =" + getTimeOutMs() + ", cid=" + this.cid + ", sid=" + this.sid + ",payType = " + this.payType + ", productId =" + this.productId + ", payFlowTypeId =" + this.payFlowTypeId + ",subscriptionType = " + this.subscriptionType + ",oldProductId = " + this.oldProductId + ",prorationMode = " + this.prorationMode + '}';
    }
}
