package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class n extends b {
    public com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            n.this.hu();
        }
    };
    public final com.kwad.components.ad.reward.e.m gP = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.b.q qVar) {
            if (qVar != null && qVar.type == 1) {
                n.this.qn.oI.release();
                n.this.qn.fA();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.oI.a(this.gO);
        com.kwad.components.ad.reward.c.fd().a(this.gP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.gO);
        com.kwad.components.ad.reward.c.fd().b(this.gP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu() {
        com.kwad.components.ad.reward.g gVar = this.qn;
        if (com.kwad.components.core.s.j.d(gVar.mAdTemplate, gVar.pc)) {
            com.kwad.components.ad.reward.g gVar2 = this.qn;
            com.kwad.components.core.s.j.e(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.x(this.qn)) {
            com.kwad.components.ad.reward.g gVar3 = this.qn;
            if (!com.kwad.components.core.s.j.d(gVar3.mAdTemplate, gVar3.pc)) {
                this.qn.fA();
                return;
            }
        }
        bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.qn.fA();
            }
        }, 200L);
    }
}
