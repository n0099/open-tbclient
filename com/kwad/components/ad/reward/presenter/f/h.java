package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.e.o;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.e;
import com.kwad.sdk.components.p;
/* loaded from: classes10.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public boolean wA;
    @Nullable
    public View wD;
    public aw wy;
    public boolean wz;
    public boolean wE = false;
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            h.this.wC.setVisibility(8);
        }
    };
    public g.a wF = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void fS() {
            h.this.wA = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fT() {
            h.this.wA = true;
            h.this.iW();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fU() {
            h.this.wA = false;
            if (h.this.wy != null) {
                h.this.wy.sl();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void fV() {
            h.this.wA = false;
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hK() {
        return R.id.obfuscated_res_0x7f0913a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iW() {
        aw awVar = this.wy;
        if (awVar != null && this.wA) {
            if (!this.wz) {
                awVar.sg();
                this.wy.sh();
                this.wz = true;
                return;
            }
            awVar.sk();
        }
    }

    private e.b iZ() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.a.e.b
            public final int ja() {
                o oVar = h.this.qn.pn;
                if (oVar != null) {
                    return com.kwad.sdk.d.a.a.b(h.this.getContext(), oVar.cf());
                }
                if (h.this.wD != null) {
                    ViewGroup.LayoutParams layoutParams = h.this.wD.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        return com.kwad.sdk.d.a.a.b(h.this.getContext(), h.this.wD.getHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    return com.kwad.sdk.d.a.a.b(h.this.getContext(), h.this.wD.getHeight());
                }
                return 0;
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.a(this.wF);
        this.qn.oL.a(this);
        this.qn.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        super.bF();
        iW();
        this.wE = true;
        this.wC.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        if (this.wE) {
            this.wC.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        if (this.wE) {
            this.wC.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dk(this.qn.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        super.onUnbind();
        this.qn.b(this.wF);
        this.qn.oL.b(this);
        this.qn.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().b(this);
        this.qn.a((com.kwad.components.core.webview.tachikoma.e.a) null);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        this.wD = view2;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wy = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aI = com.kwad.sdk.d.a.a.aI(getContext());
        aVar.width = (int) ((com.kwad.sdk.d.a.a.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((com.kwad.sdk.d.a.a.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        this.wE = false;
        this.wC.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(new com.kwad.components.core.webview.tachikoma.a.e(iZ()));
    }
}
