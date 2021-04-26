package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public class HasChargeInActivityResult {
    public int activityId;
    public int chargeCount;
    public String endTime;
    public boolean hasCharge;
    public String startTime;
    public String tip;

    public HasChargeInActivityResult(int i2, String str, String str2, boolean z, String str3, int i3) {
        this.activityId = i2;
        this.startTime = str;
        this.endTime = str2;
        this.hasCharge = z;
        this.tip = str3;
        this.chargeCount = i3;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public int getChargeCount() {
        return this.chargeCount;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public boolean getHasCharge() {
        return this.hasCharge;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTip() {
        return this.tip;
    }
}
