package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/GetUserCouponStoreParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "toString", "()Ljava/lang/String;", "", "goodsType", "I", "getGoodsType", "()I", "setGoodsType", "(I)V", "", "hasUsed", "Z", "getHasUsed", "()Z", "setHasUsed", "(Z)V", "includeExpire", "getIncludeExpire", "setIncludeExpire", "page", "getPage", "setPage", "pageSize", "getPageSize", "setPageSize", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class GetUserCouponStoreParams extends RequestParams {
    public int goodsType;
    public boolean hasUsed;
    public boolean includeExpire;
    public int page;
    public int pageSize;

    public final int getGoodsType() {
        return this.goodsType;
    }

    public final boolean getHasUsed() {
        return this.hasUsed;
    }

    public final boolean getIncludeExpire() {
        return this.includeExpire;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setGoodsType(int i2) {
        this.goodsType = i2;
    }

    public final void setHasUsed(boolean z) {
        this.hasUsed = z;
    }

    public final void setIncludeExpire(boolean z) {
        this.includeExpire = z;
    }

    public final void setPage(int i2) {
        this.page = i2;
    }

    public final void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public String toString() {
        return "ChargeCurrencyReqParams{cmd=" + getCmd() + "uid=" + getUid() + ", seq=" + getSeq() + ", appId=" + getAppId() + ", ticket =" + getToken() + ",goodsType = " + this.goodsType + ", hasUsed =" + this.hasUsed + ", page =" + this.page + ", pageSize =" + this.pageSize + ", includeExpire =" + this.includeExpire + '}';
    }
}
