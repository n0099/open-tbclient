package com.kwad.components.ad.fullscreen.b;

import android.view.ViewGroup;
import com.kwad.components.ad.fullscreen.b.kwai.f;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.h;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.ad.reward.presenter.n;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements e, com.kwad.components.ad.reward.g.b, e.b {
    public com.kwad.components.ad.fullscreen.b er;
    public ViewGroup es;
    public com.kwad.components.core.g.b et;
    public n eu;

    public b(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, k kVar) {
        this.et = bVar;
        this.er = bVar2;
        this.es = viewGroup;
        this.nM = kVar;
        kVar.a((e.a) this);
        this.nM.a((e.b) this);
        bF();
    }

    private void bF() {
        com.kwad.components.ad.fullscreen.b bVar = this.er;
        if (bVar == null) {
            return;
        }
        AdTemplate adTemplate = bVar.getAdTemplate();
        AdInfo by = this.er.by();
        boolean z = this.er.bz() && !ag.zL();
        a(new r());
        if (com.kwad.sdk.core.response.a.a.ao(by)) {
            a(new com.kwad.components.ad.reward.presenter.c());
        }
        a(new i());
        a(new com.kwad.components.ad.reward.presenter.platdetail.b());
        a(new c());
        a(new com.kwad.components.ad.reward.presenter.c.b());
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c());
        }
        a(new a());
        n nVar = new n(adTemplate, false, false);
        this.eu = nVar;
        a(nVar);
        a(new com.kwad.components.ad.reward.presenter.a.b(adTemplate, false));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new d(adTemplate, by, this.es));
        a(new h());
        if (com.kwad.sdk.core.response.a.b.bB(adTemplate)) {
            a(new f());
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.a((com.kwad.components.ad.reward.d.e) this);
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        this.nM.F(true);
    }

    public final boolean bG() {
        n nVar = this.eu;
        if (nVar != null) {
            return nVar.bG();
        }
        return false;
    }

    public final boolean bH() {
        n nVar = this.eu;
        return nVar != null && nVar.bH();
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void bI() {
        com.kwad.components.ad.reward.g.a.a(getActivity(), this, this.nM.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean bJ() {
        return false;
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void bK() {
        this.nM.mAdOpenInteractionListener.j(false);
        gR();
    }

    @Override // com.kwad.components.ad.reward.g.c
    public final void onPlayAgainClick() {
        this.nM.fu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this);
    }
}
