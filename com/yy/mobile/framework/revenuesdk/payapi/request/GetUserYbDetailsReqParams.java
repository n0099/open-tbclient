package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/GetUserYbDetailsReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "endTime", "J", "getEndTime", "()J", "setEndTime", "(J)V", "", "page", "I", "getPage", "()I", "setPage", "(I)V", "pagesize", "getPagesize", "setPagesize", "startTime", "getStartTime", "setStartTime", "<init>", "()V", "payapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class GetUserYbDetailsReqParams extends RequestParams {
    public long endTime;
    public long startTime;
    public int pagesize = 20;
    public int page = 1;

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPagesize() {
        return this.pagesize;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setPage(int i2) {
        this.page = i2;
    }

    public final void setPagesize(int i2) {
        this.pagesize = i2;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }
}
