package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.i;
@Keep
/* loaded from: classes7.dex */
public class PayOrderResult {
    public final String closeRiskEnhance;
    public final String expand;
    public final String orderId;
    public final String payChannel;
    public final String payMethod;
    public final String payUrl;
    public final i pollingModeInfo;
    public final int result;

    public PayOrderResult(int i2, String str, String str2, String str3, String str4, String str5, String str6, i iVar) {
        this.result = i2;
        this.payUrl = str;
        this.payChannel = str2;
        this.orderId = str3;
        this.payMethod = str4;
        this.closeRiskEnhance = str5;
        this.expand = str6;
        this.pollingModeInfo = iVar;
    }

    public String getCloseRiskEnhance() {
        return this.closeRiskEnhance;
    }

    public String getExpand() {
        return this.expand;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPayChannel() {
        return this.payChannel;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public String getPayUrl() {
        return this.payUrl;
    }

    public i getPollingModeInfo() {
        return this.pollingModeInfo;
    }

    public int getResult() {
        return this.result;
    }

    public int getResultCode() {
        return this.result;
    }

    public boolean isSuccess() {
        return this.result == 1;
    }

    public String toString() {
        return "PayOrderResult{result=" + this.result + ", payUrl='" + this.payUrl + "', payChannel='" + this.payChannel + "', orderId='" + this.orderId + "', payMethod='" + this.payMethod + "', expand='" + this.expand + "'}";
    }
}
