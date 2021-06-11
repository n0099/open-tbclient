package com.yy.mobile.framework.revenuesdk.payapi.bean;
/* loaded from: classes7.dex */
public class PurchaseStatusInfo {
    public String productId = "";
    public String orderId = "";
    public long uid = 0;
    public int status = 0;
    public String chorderid = "";
    public String purchaseData = "";
    public String purchaseSign = "";

    public String toString() {
        return "PurchaseStatusInfo{productId=" + this.productId + ", orderId=" + this.orderId + ", uid='" + this.uid + ", status='" + this.status + ", chorderid='" + this.chorderid + ", purchaseData='" + this.purchaseData + ", purchaseSign='" + this.purchaseSign + '}';
    }
}
