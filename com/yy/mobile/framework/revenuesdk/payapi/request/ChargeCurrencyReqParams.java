package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b:\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010\u0016R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0007\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010\u0016R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0007\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0007\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000b¨\u0006="}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ChargeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", IAdRequestParam.CELL_ID, "I", "getCid", "()I", "setCid", "(I)V", "currencyType", "getCurrencyType", "setCurrencyType", "from", "getFrom", "setFrom", "oldProductId", "Ljava/lang/String;", "getOldProductId", "setOldProductId", "(Ljava/lang/String;)V", "payChannel", "getPayChannel", "setPayChannel", "payMethod", "getPayMethod", "setPayMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", "productId", "getProductId", "setProductId", "prorationMode", "getProrationMode", "setProrationMode", "returnUrl", "getReturnUrl", "setReturnUrl", "sid", "getSid", "setSid", "", "srcAmount", "D", "getSrcAmount", "()D", "setSrcAmount", "(D)V", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "Companion", "payapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ChargeCurrencyReqParams extends RequestParams {
    public static final a Companion = new a(null);
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

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public final ChargeCurrencyReqParams a(ChargeCurrencyReqParams chargeCurrencyReqParams) {
            ChargeCurrencyReqParams chargeCurrencyReqParams2 = new ChargeCurrencyReqParams();
            chargeCurrencyReqParams2.clone(chargeCurrencyReqParams);
            return chargeCurrencyReqParams2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
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
