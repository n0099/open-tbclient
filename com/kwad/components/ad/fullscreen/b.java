package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b {
    public final boolean gt = com.kwad.components.ad.reward.a.b.gC();
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
    }

    public final AdInfo bH() {
        return this.mAdInfo;
    }

    public final boolean bI() {
        return com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }
}
