package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.UserCouponStore;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class UserCouponStoreResult {
    public long serverCurrentTime;
    public List<UserCouponStore> userCouponStoreList;

    public UserCouponStoreResult(long j, List<UserCouponStore> list) {
        this.serverCurrentTime = j;
        this.userCouponStoreList = list;
    }

    public long getServerCurrentTime() {
        return this.serverCurrentTime;
    }

    public List<UserCouponStore> getUserCouponStoreList() {
        return this.userCouponStoreList;
    }

    public String toString() {
        return "UserCouponStoreResult{serverCurrentTime=" + this.serverCurrentTime + ", userCouponStoreList=" + this.userCouponStoreList + '}';
    }
}
