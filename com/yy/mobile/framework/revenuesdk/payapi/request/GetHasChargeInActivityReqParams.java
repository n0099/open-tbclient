package com.yy.mobile.framework.revenuesdk.payapi.request;

import androidx.annotation.Keep;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/GetHasChargeInActivityReqParams;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "", "activityId", "I", "getActivityId", "()I", "setActivityId", "(I)V", "currencyType", "getCurrencyType", "setCurrencyType", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class GetHasChargeInActivityReqParams extends RequestParams {
    public int activityId;
    public int currencyType;

    public final int getActivityId() {
        return this.activityId;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final void setActivityId(int i2) {
        this.activityId = i2;
    }

    public final void setCurrencyType(int i2) {
        this.currencyType = i2;
    }
}
