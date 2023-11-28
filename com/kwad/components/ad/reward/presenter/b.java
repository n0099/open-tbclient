package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g qn;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) HU();
        this.qn = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    public final void hn() {
        this.qn.hn();
    }

    public final boolean ho() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate));
    }
}
