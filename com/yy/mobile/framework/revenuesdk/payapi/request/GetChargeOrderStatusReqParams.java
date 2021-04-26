package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/GetChargeOrderStatusReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "orderId", "Ljava/lang/String;", "getOrderId", "setOrderId", "(Ljava/lang/String;)V", "", "sid", "J", "getSid", "()J", "setSid", "(J)V", "<init>", "()V", "payapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class GetChargeOrderStatusReqParams extends RequestParams {
    public String orderId;
    public long sid;

    public final String getOrderId() {
        return this.orderId;
    }

    public final long getSid() {
        return this.sid;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setSid(long j) {
        this.sid = j;
    }

    public String toString() {
        return "GetChargeOrderStatusReqParams{, uid=" + getUid() + ", orderId=" + this.orderId + ", sid=" + this.sid + '}';
    }
}
