package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CouponDiscountInfo;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CouponDiscountResult {
    public List<CouponDiscountInfo> discountList;
    public int userCouponId;

    public CouponDiscountResult(int i2, List<CouponDiscountInfo> list) {
        this.userCouponId = i2;
        this.discountList = list;
    }

    public List<CouponDiscountInfo> getCouponDiscountInfoList() {
        return this.discountList;
    }

    public int getUserCouponId() {
        return this.userCouponId;
    }

    public String toString() {
        return "CouponDiscountResult{userCouponId=" + this.userCouponId + ", discountList=" + this.discountList + '}';
    }
}
