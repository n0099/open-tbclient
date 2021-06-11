package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.RevenueRecord;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class RevenueRecordResult {
    public final boolean hasMore;
    public final List<RevenueRecord> revenueRecordList;

    public RevenueRecordResult(List<RevenueRecord> list, boolean z) {
        this.revenueRecordList = list;
        this.hasMore = z;
    }
}
