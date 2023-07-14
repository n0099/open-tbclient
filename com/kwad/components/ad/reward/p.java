package com.kwad.components.ad.reward;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class p extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.e, com.kwad.components.ad.reward.g.b, e.b {
    public ViewGroup es;
    public com.kwad.components.ad.reward.presenter.n eu;
    public com.kwad.components.ad.reward.model.c mModel;
    public k nM;
    @Nullable
    public a nN;
    @Nullable
    public com.kwad.components.ad.reward.presenter.p nO;

    /* loaded from: classes10.dex */
    public interface a {
        void onUnbind();
    }

    public p(com.kwad.components.core.g.b bVar, ViewGroup viewGroup, com.kwad.components.ad.reward.model.c cVar, k kVar) {
        this.es = viewGroup;
        this.mModel = cVar;
        this.nM = kVar;
        kVar.a((e.a) this);
        this.nM.a((e.b) this);
        a(bVar, cVar);
    }

    private void a(com.kwad.components.core.g.b bVar, com.kwad.components.ad.reward.model.c cVar) {
        com.kwad.components.ad.reward.model.c cVar2 = this.mModel;
        if (cVar2 == null) {
            return;
        }
        AdInfo by = cVar2.by();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        a(new com.kwad.components.ad.reward.presenter.r());
        if (com.kwad.sdk.core.response.a.a.ao(by)) {
            a(new com.kwad.components.ad.reward.presenter.c());
        }
        a(new com.kwad.components.ad.reward.presenter.i());
        a(new com.kwad.components.ad.reward.presenter.f());
        a(new com.kwad.components.ad.reward.presenter.platdetail.b());
        a(new com.kwad.components.ad.reward.presenter.platdetail.kwai.e());
        a(new com.kwad.components.ad.reward.presenter.c.b());
        boolean gL = cVar.gL();
        boolean gM = cVar.gM();
        boolean z = cVar.bz() && !ag.zL();
        if (!gL && !gM && !z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c());
        }
        a(new com.kwad.components.ad.reward.presenter.j());
        com.kwad.components.ad.reward.presenter.n nVar = new com.kwad.components.ad.reward.presenter.n(adTemplate);
        this.eu = nVar;
        a(nVar);
        a(new com.kwad.components.ad.reward.presenter.b(by));
        a(new com.kwad.components.ad.reward.presenter.a.b(adTemplate, true));
        a(new com.kwad.components.ad.reward.presenter.kwai.a());
        a(new com.kwad.components.ad.reward.presenter.q());
        a(new com.kwad.components.ad.reward.presenter.d(adTemplate, by, this.es));
        if (t(adTemplate)) {
            com.kwad.components.ad.reward.presenter.p pVar = new com.kwad.components.ad.reward.presenter.p();
            this.nO = pVar;
            a(pVar);
        }
        a(new com.kwad.components.ad.reward.presenter.h());
    }

    public static boolean t(AdTemplate adTemplate) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        return com.kwad.sdk.core.response.a.a.bP(bQ) && !(com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(bQ)) || com.kwad.sdk.core.response.a.d.p(adTemplate));
    }

    public final void a(@Nullable a aVar) {
        this.nN = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.a((com.kwad.components.ad.reward.d.e) this);
        com.kwad.components.ad.reward.b.a.gp().setCallerContext(this.nM);
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        this.nM.F(true);
    }

    public final boolean bH() {
        com.kwad.components.ad.reward.presenter.n nVar = this.eu;
        return nVar != null && nVar.bH();
    }

    @Override // com.kwad.components.ad.reward.presenter.e.b
    public final void bI() {
        com.kwad.components.ad.reward.g.a.a(getActivity(), this, this.nM.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.a
    public final boolean bJ() {
        com.kwad.components.ad.reward.presenter.p pVar = this.nO;
        if (pVar == null) {
            return false;
        }
        if (pVar.isRefluxVisible()) {
            return true;
        }
        return this.nO.hm();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void bK() {
        this.nM.mAdOpenInteractionListener.j(false);
        gR();
    }

    public final BackPressHandleResult fS() {
        com.kwad.components.ad.reward.presenter.n nVar = this.eu;
        if (nVar == null || !nVar.bG()) {
            com.kwad.components.ad.reward.presenter.p pVar = this.nO;
            return pVar != null ? pVar.fS() : BackPressHandleResult.NOT_HANDLED;
        }
        return BackPressHandleResult.HANDLED;
    }

    public final boolean isRefluxVisible() {
        com.kwad.components.ad.reward.presenter.p pVar = this.nO;
        return pVar != null && pVar.isRefluxVisible();
    }

    @Override // com.kwad.components.ad.reward.g.c
    public final void onPlayAgainClick() {
        this.nM.fu();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this);
        a aVar = this.nN;
        if (aVar != null) {
            aVar.onUnbind();
        }
        com.kwad.components.ad.reward.b.a.gp().reset();
    }
}
