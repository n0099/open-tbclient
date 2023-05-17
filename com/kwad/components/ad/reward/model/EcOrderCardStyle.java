package com.kwad.components.ad.reward.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
/* loaded from: classes9.dex */
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
        if (com.kwad.components.ad.reward.kwai.b.j(adInfo) || com.kwad.components.ad.reward.kwai.b.i(adInfo)) {
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            boolean hasSpike = bN.hasSpike();
            boolean hasCoupon = bN.hasCoupon();
            return (hasSpike && hasCoupon) ? SPIKE_AND_COUPON : hasSpike ? SPIKE : hasCoupon ? COUPON : bN.hasOriginalPrice() ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
        }
        return null;
    }

    public final int getValue() {
        return this.value;
    }
}
