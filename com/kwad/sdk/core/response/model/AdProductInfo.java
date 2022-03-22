package com.kwad.sdk.core.response.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class AdProductInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -7038691521398433079L;
    public List<CouponInfo> couponList;
    public String icon;
    public String name;
    public String originPrice;
    public String price;

    public List<CouponInfo> getCouponList() {
        return this.couponList;
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

    public boolean isCouponListEmpty() {
        List<CouponInfo> list = this.couponList;
        return list == null || list.size() == 0;
    }
}
