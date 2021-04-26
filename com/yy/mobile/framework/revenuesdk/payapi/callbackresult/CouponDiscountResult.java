package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import d.r.b.a.a.i.c.d;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CouponDiscountResult {
    public List<d> discountList;
    public int userCouponId;

    public CouponDiscountResult(int i2, List<d> list) {
        this.userCouponId = i2;
        this.discountList = list;
    }

    public List<d> getCouponDiscountInfoList() {
        return this.discountList;
    }

    public int getUserCouponId() {
        return this.userCouponId;
    }

    public String toString() {
        return "CouponDiscountResult{userCouponId=" + this.userCouponId + ", discountList=" + this.discountList + '}';
    }
}
