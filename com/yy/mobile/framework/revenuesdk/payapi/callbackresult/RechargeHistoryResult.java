package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ChargeOrder;
import java.util.List;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/RechargeHistoryResult;", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ChargeOrder;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "result", "I", "getResult", "()I", "<init>", "(Ljava/util/List;I)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class RechargeHistoryResult {
    public final List<ChargeOrder> list;
    public final int result;

    public RechargeHistoryResult(List<ChargeOrder> list, int i2) {
        this.list = list;
        this.result = i2;
    }

    public final List<ChargeOrder> getList() {
        return this.list;
    }

    public final int getResult() {
        return this.result;
    }
}
