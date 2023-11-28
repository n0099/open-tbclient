package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/GetSplitOrderConfigReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", PayUiEventContent.AMOUNT, "J", "getAmount", "()J", "setAmount", "(J)V", "", "currencyType", "I", "getCurrencyType", "()I", "setCurrencyType", "(I)V", "orderId", "Ljava/lang/String;", "getOrderId", "setOrderId", "(Ljava/lang/String;)V", "type", "getType", "setType", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class GetSplitOrderConfigReqParams extends RequestParams {
    public long amount;
    public int currencyType;
    public String orderId;
    public int type = 1;

    public final long getAmount() {
        return this.amount;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAmount(long j) {
        this.amount = j;
    }

    public final void setCurrencyType(int i) {
        this.currencyType = i;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "GetSplitOrderConfigReqParams{, type=" + this.type + ", orderId=" + this.orderId + ", amount=" + this.amount + ", currencyType=" + this.currencyType + '}';
    }
}
