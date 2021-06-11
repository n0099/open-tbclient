package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010\u0010R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0007\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u000bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010\u0010R\"\u00105\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0007\u001a\u0004\b6\u0010\t\"\u0004\b7\u0010\u000b¨\u0006:"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ReportPurchaseReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", "currencyType", "I", "getCurrencyType", "()I", "setCurrencyType", "(I)V", "data", "Ljava/lang/String;", "getData", "setData", "(Ljava/lang/String;)V", "from", "getFrom", "setFrom", "orderId", "getOrderId", "setOrderId", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;", "payMethod", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;", "getPayMethod", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;", "setPayMethod", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod;)V", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "payType", "Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "getPayType", "()Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;", "setPayType", "(Lcom/yy/mobile/framework/revenuesdk/payapi/PayType;)V", "productid", "getProductid", "setProductid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "purchaseInfo", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "getPurchaseInfo", "()Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "setPurchaseInfo", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;)V", "sid", "getSid", "setSid", "sign", "getSign", "setSign", "subscriptionType", "getSubscriptionType", "setSubscriptionType", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public class ReportPurchaseReqParams extends RequestParams {
    public int currencyType;
    public String data;
    public int from;
    public String orderId = "";
    public IPayMethod payMethod;
    public PayType payType;
    public String productid;
    public PurchaseInfo purchaseInfo;
    public int sid;
    public String sign;
    public int subscriptionType;

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final String getData() {
        return this.data;
    }

    public final int getFrom() {
        return this.from;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final IPayMethod getPayMethod() {
        return this.payMethod;
    }

    public final PayType getPayType() {
        return this.payType;
    }

    public final String getProductid() {
        return this.productid;
    }

    public final PurchaseInfo getPurchaseInfo() {
        return this.purchaseInfo;
    }

    public final int getSid() {
        return this.sid;
    }

    public final String getSign() {
        return this.sign;
    }

    public final int getSubscriptionType() {
        return this.subscriptionType;
    }

    public final void setCurrencyType(int i2) {
        this.currencyType = i2;
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final void setFrom(int i2) {
        this.from = i2;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayMethod(IPayMethod iPayMethod) {
        this.payMethod = iPayMethod;
    }

    public final void setPayType(PayType payType) {
        this.payType = payType;
    }

    public final void setProductid(String str) {
        this.productid = str;
    }

    public final void setPurchaseInfo(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }

    public final void setSid(int i2) {
        this.sid = i2;
    }

    public final void setSign(String str) {
        this.sign = str;
    }

    public final void setSubscriptionType(int i2) {
        this.subscriptionType = i2;
    }

    public String toString() {
        return "ReportPurchaseReqParams{cmd=" + getCmd() + ", uid=" + getUid() + ", appId=" + getAppId() + ", clientVersion =" + getClientVersion() + ",requestTime = " + getRequestTime() + ", clientVersion =" + getClientVersion() + ", productid =" + this.productid + ", retryCount =" + getRetryCount() + ", intervalMs =" + getIntervalMs() + ", retryType =" + getRetryType() + ", timeOutMs =" + getTimeOutMs() + ", data=" + this.data + ", sign=" + this.sign + ",orderId = " + this.orderId + ",payType = " + this.payType + ",subscriptionType = " + this.subscriptionType + '}';
    }
}
