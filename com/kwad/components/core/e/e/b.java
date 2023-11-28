package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public class b extends Presenter {
    public c Lk;
    public AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        c cVar = (c) HU();
        this.Lk = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(cVar.Lj.getAdTemplate());
    }
}
