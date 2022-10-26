package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class AdProductInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -7038691521398433079L;
    public List couponList;
    public String icon;
    public String name;
    public String originPrice;
    public String price;
    public String rating;
    public SpikeInfo seckillInfo;
    public String volume;

    /* loaded from: classes7.dex */
    public class SpikeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -4379476990559885495L;
        public long endTime;
        public int originalStock;
        public int soldStock;
    }

    public List getCouponList() {
        return this.couponList;
    }

    public CouponInfo getFirstCouponList() {
        if (isCouponListEmpty()) {
            return null;
        }
        return (CouponInfo) this.couponList.get(0);
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginPrice() {
        return this.originPrice;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRating() {
        return this.rating;
    }

    public String getVolume() {
        return this.volume;
    }

    public boolean hasCoupon() {
        return !isCouponListEmpty();
    }

    public boolean hasOriginalPrice() {
        return !TextUtils.isEmpty(this.originPrice);
    }

    public boolean hasSpike() {
        SpikeInfo spikeInfo = this.seckillInfo;
        return spikeInfo != null && spikeInfo.endTime > 0;
    }

    public boolean isCouponListEmpty() {
        List list = this.couponList;
        return list == null || list.size() == 0;
    }
}
