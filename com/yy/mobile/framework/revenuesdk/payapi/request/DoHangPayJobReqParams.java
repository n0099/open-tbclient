package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/DoHangPayJobReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/ReportPurchaseReqParams;", "", "packageName", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "productId", "getProductId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class DoHangPayJobReqParams extends ReportPurchaseReqParams {
    public final String packageName;
    public final String productId;

    public DoHangPayJobReqParams(String str, String str2) {
        this.productId = str;
        this.packageName = str2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getProductId() {
        return this.productId;
    }
}
