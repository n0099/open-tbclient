package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/ExchangeCurrencyReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "amount", "I", "getAmount", "()I", "setAmount", "(I)V", "configId", "getConfigId", "setConfigId", "destCurrencyType", "getDestCurrencyType", "setDestCurrencyType", "", "ipAddress", "Ljava/lang/String;", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "srcCurrencyType", "getSrcCurrencyType", "setSrcCurrencyType", "<init>", "(III)V", "payapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ExchangeCurrencyReqParams extends RequestParams {
    public int amount;
    public int configId;
    public int destCurrencyType;
    public String ipAddress = "";
    public int srcCurrencyType;

    public ExchangeCurrencyReqParams(int i2, int i3, int i4) {
        this.srcCurrencyType = i2;
        this.destCurrencyType = i3;
        this.amount = i4;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getConfigId() {
        return this.configId;
    }

    public final int getDestCurrencyType() {
        return this.destCurrencyType;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final int getSrcCurrencyType() {
        return this.srcCurrencyType;
    }

    public final void setAmount(int i2) {
        this.amount = i2;
    }

    public final void setConfigId(int i2) {
        this.configId = i2;
    }

    public final void setDestCurrencyType(int i2) {
        this.destCurrencyType = i2;
    }

    public final void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public final void setSrcCurrencyType(int i2) {
        this.srcCurrencyType = i2;
    }
}
