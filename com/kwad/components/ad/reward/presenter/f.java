package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.m.f;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class f extends a implements f.a {
    public com.kwad.components.ad.reward.j.a eF;
    public AdInfo mAdInfo;
    public com.kwad.components.core.m.f pJ;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
        this.mAdInfo = bQ;
        com.kwad.components.core.m.f fVar = this.pJ;
        if (fVar == null) {
            this.pJ = new com.kwad.components.core.m.f(com.kwad.sdk.core.response.a.a.ag(bQ));
        } else {
            fVar.aw(com.kwad.sdk.core.response.a.a.ag(bQ));
        }
        com.kwad.components.ad.reward.k kVar = this.nM;
        this.eF = kVar.eF;
        this.pJ.a(kVar.mContext, this);
    }

    @Override // com.kwad.components.core.m.f.a
    public final void gW() {
        com.kwad.components.ad.reward.d.a aVar = this.nM.mAdOpenInteractionListener;
        if (aVar != null) {
            aVar.onRewardVerify();
        }
        this.eF.release();
        this.nM.fr();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.pJ.au(this.nM.mContext);
    }
}
