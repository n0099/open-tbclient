package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.m;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class UserCouponStoreResult {
    public long serverCurrentTime;
    public List<m> userCouponStoreList;

    public UserCouponStoreResult(long j, List<m> list) {
        this.serverCurrentTime = j;
        this.userCouponStoreList = list;
    }

    public long getServerCurrentTime() {
        return this.serverCurrentTime;
    }

    public List<m> getUserCouponStoreList() {
        return this.userCouponStoreList;
    }

    public String toString() {
        return "UserCouponStoreResult{serverCurrentTime=" + this.serverCurrentTime + ", userCouponStoreList=" + this.userCouponStoreList + '}';
    }
}
