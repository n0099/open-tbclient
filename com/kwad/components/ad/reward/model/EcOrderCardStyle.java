package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
/* loaded from: classes10.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);
    
    public int value;

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    @Nullable
    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        boolean z;
        if (!com.kwad.components.ad.reward.a.b.k(adInfo) && !com.kwad.components.ad.reward.a.b.j(adInfo)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return null;
        }
        AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
        boolean hasSpike = cM.hasSpike();
        boolean hasCoupon = cM.hasCoupon();
        boolean hasOriginalPrice = cM.hasOriginalPrice();
        if (hasSpike && hasCoupon) {
            return SPIKE_AND_COUPON;
        }
        if (hasSpike) {
            return SPIKE;
        }
        if (hasCoupon) {
            return COUPON;
        }
        if (hasOriginalPrice) {
            return NO_SPIKE_AND_NO_COUPON;
        }
        return DEFAULT;
    }

    public final int getValue() {
        return this.value;
    }
}
