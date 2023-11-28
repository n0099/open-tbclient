package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cJ(adInfo)) {
            return "live";
        }
        if (com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            return "image";
        }
        if (com.kwad.sdk.core.response.b.a.bX(adInfo)) {
            return "reward_preview";
        }
        return "video";
    }
}
