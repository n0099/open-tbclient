package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class e extends b {
    public c gh;
    public AdInfo mAdInfo;

    public e(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.gh = (c) xR();
        if (!(com.kwad.sdk.core.response.a.a.bD(this.mAdInfo) || com.kwad.sdk.core.response.a.a.bJ(this.mAdInfo)) || this.gh.mAdTemplate.mAdScene == null) {
            return;
        }
        this.mAdInfo.adConversionInfo.deeplinkUrl = com.kwad.components.core.c.a.d.e(getContext(), this.mAdInfo, this.gh.mAdTemplate.mAdScene);
    }
}
