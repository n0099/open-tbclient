package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    public AdTemplate mAdTemplate;
    public Context mContext;

    public c() {
        a(new f());
        a(new b());
        a(new com.kwad.components.ad.reward.presenter.c.c());
    }

    private void hy() {
        if (k.c(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        k kVar = this.nM;
        this.mAdTemplate = kVar.mAdTemplate;
        this.mContext = kVar.mContext;
        hy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-bottom-card-v2".equals(str)) {
            this.nM.ml.S(true);
        }
    }
}
