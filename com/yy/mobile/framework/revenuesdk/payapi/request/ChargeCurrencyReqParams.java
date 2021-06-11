package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bA\u0010BJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010\u001dR\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u0010\u001dR\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000e\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012¨\u0006D"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", "appClientExpand", "Ljava/util/Map;", "getAppClientExpand", "()Ljava/util/Map;", "setAppClientExpand", "(Ljava/util/Map;)V", "", IAdRequestParam.CELL_ID, "I", "getCid", "()I", "setCid", "(I)V", "currencyType", "getCurrencyType", "setCurrencyType", "from", "getFrom", "setFrom", "oldProductId", "Ljava/lang/String;", "getOldProductId", "setOldProductId", "(Ljava/lang/String;)V", "payChannel", "getPayChannel", "setPayChannel", "payMethod", "getPayMethod", "setPayMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", "productId", "getProductId", "setProductId", "prorationMode", "getProrationMode", "setProrationMode", "returnUrl", "getReturnUrl", "setReturnUrl", "sid", "getSid", "setSid", "", "srcAmount", "D", "getSrcAmount", "()D", "setSrcAmount", "(D)V", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ChargeCurrencyReqParams extends RequestParams {
    public static final Companion Companion = new Companion(null);
    public Map<String, String> appClientExpand;
    public int cid;
    public int currencyType;
    public int from;
    public String oldProductId = "";
    public String payChannel;
    public String payMethod;
    public PayType payType;
    public String productId;
    public int prorationMode;
    public String returnUrl;
    public int sid;
    public double srcAmount;
    public int subscriptionType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams$Companion;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "other", "clone", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;)Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final ChargeCurrencyReqParams clone(ChargeCurrencyReqParams chargeCurrencyReqParams) {
            ChargeCurrencyReqParams chargeCurrencyReqParams2 = new ChargeCurrencyReqParams();
            chargeCurrencyReqParams2.clone(chargeCurrencyReqParams);
            return chargeCurrencyReqParams2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Map<String, String> getAppClientExpand() {
        return this.appClientExpand;
    }

    public final int getCid() {
        return this.cid;
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

    public final void setCid(int i2) {
        this.cid = i2;
    }

    public final void setCurrencyType(int i2) {
        this.currencyType = i2;
    }

    public final void setFrom(int i2) {
        this.from = i2;
    }

    public final void setOldProductId(String str) {
        this.oldProductId = str;
    }

    public final void setPayChannel(String str) {
        this.payChannel = str;
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

    public final void setProrationMode(int i2) {
        this.prorationMode = i2;
    }

    public final void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public final void setSid(int i2) {
        this.sid = i2;
    }

    public final void setSrcAmount(double d2) {
        this.srcAmount = d2;
    }

    public final void setSubscriptionType(int i2) {
        this.subscriptionType = i2;
    }

    public String toString() {
        return "ChargeCurrencyReqParams{cmd=" + getCmd() + ", uid=" + getUid() + ", appId=" + getAppId() + ", clientVersion =" + getClientVersion() + ",requestTime = " + getRequestTime() + ", clientVersion =" + getClientVersion() + ", retryCount =" + getRetryCount() + ", intervalMs =" + getIntervalMs() + ", retryType =" + getRetryType() + ", timeOutMs =" + getTimeOutMs() + ", cid=" + this.cid + ", sid=" + this.sid + ",payType = " + this.payType + ", productId =" + this.productId + ",subscriptionType = " + this.subscriptionType + ",oldProductId = " + this.oldProductId + ",prorationMode = " + this.prorationMode + '}';
    }
}
