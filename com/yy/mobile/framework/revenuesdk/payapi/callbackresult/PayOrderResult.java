package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
@Keep
/* loaded from: classes2.dex */
public class PayOrderResult {
    public final String closeRiskEnhance;
    public final String expand;
    public final String orderId;
    public final String payChannel;
    public final String payMethod;
    public final String payUrl;
    public final PollingModeInfo pollingModeInfo;
    public final int result;

    public PayOrderResult(int i, String str, String str2, String str3, String str4, String str5, String str6, PollingModeInfo pollingModeInfo) {
        this.result = i;
        this.payUrl = str;
        this.payChannel = str2;
        this.orderId = str3;
        this.payMethod = str4;
        this.closeRiskEnhance = str5;
        this.expand = str6;
        this.pollingModeInfo = pollingModeInfo;
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

    public PollingModeInfo getPollingModeInfo() {
        return this.pollingModeInfo;
    }

    public int getResult() {
        return this.result;
    }

    public int getResultCode() {
        return this.result;
    }

    public boolean isSuccess() {
        if (this.result == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "PayOrderResult{result=" + this.result + ", payUrl='" + this.payUrl + "', payChannel='" + this.payChannel + "', orderId='" + this.orderId + "', payMethod='" + this.payMethod + "', expand='" + this.expand + "'}";
    }
}
