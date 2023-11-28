package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.aw;
/* loaded from: classes10.dex */
public final class e implements g.a {
    public boolean wA;
    public aw wy;
    public boolean wz;

    private void iW() {
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

    public final void bF() {
        iW();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fS() {
        this.wA = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fT() {
        this.wA = true;
        iW();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
        this.wA = false;
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sl();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        this.wA = false;
    }

    public final void iX() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
    }

    public final void b(aw awVar) {
        this.wy = awVar;
    }

    public final void y(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void z(com.kwad.components.ad.reward.g gVar) {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        gVar.b(this);
    }
}
