package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.l;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class RevenueRecordResult {
    public final boolean hasMore;
    public final List<l> revenueRecordList;

    public RevenueRecordResult(List<l> list, boolean z) {
        this.revenueRecordList = list;
        this.hasMore = z;
    }
}
