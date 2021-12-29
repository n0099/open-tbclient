package com.kwad.sdk.contentalliance.coupon.model;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class CouponStatusInfo extends a implements b, Serializable {
    public static final long serialVersionUID = -6390497068195603159L;
    public int statusCode = -1;
    public String statusName = "";
    public double currTotalAmount = 0.0d;
    public int couponLeftTimes = 0;
    public boolean isNewUser = false;
}
