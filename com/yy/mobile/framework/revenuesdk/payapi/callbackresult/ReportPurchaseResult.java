package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public class ReportPurchaseResult {
    public String orderId;
    public String purchaseData;
    public String purchaseSign;

    public ReportPurchaseResult(String str, String str2, String str3) {
        this.purchaseData = str;
        this.purchaseSign = str2;
        this.orderId = str3;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPurchaseData() {
        return this.purchaseData;
    }

    public String getPurchaseSign() {
        return this.purchaseSign;
    }

    public String toString() {
        return "ReportPurchaseResult{purchaseData=" + this.purchaseData + ", purchaseSign='" + this.purchaseSign + "', orderId='" + this.orderId + "'}";
    }
}
