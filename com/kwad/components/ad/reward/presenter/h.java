package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class h extends b implements com.kwad.sdk.b.a {
    public AdInfo mAdInfo;

    @Override // com.kwad.sdk.b.a
    public final void O(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        com.kwad.sdk.b.b.zt().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.b.b.zt().b(this);
    }

    @Override // com.kwad.sdk.b.a
    public final void N(String str) {
        if (!TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            return;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        if (!com.kwad.sdk.core.response.b.a.aO(dP) || com.kwad.sdk.core.response.b.a.aN(dP) != 1) {
            com.kwad.components.ad.reward.e.b bVar = this.qn.oH;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.qn.oI.pause();
            this.qn.fA();
        }
    }
}
