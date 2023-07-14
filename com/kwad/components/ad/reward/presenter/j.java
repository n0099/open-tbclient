package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class j extends a {
    public com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.j.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (g.r(j.this.nM)) {
                bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.j.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.nM.fr();
                    }
                }, 200L);
            } else {
                j.this.nM.fr();
            }
        }
    };
    public final com.kwad.components.ad.reward.d.i ep = new com.kwad.components.ad.reward.d.i() { // from class: com.kwad.components.ad.reward.presenter.j.2
        @Override // com.kwad.components.ad.reward.d.i
        public final void a(com.kwad.components.core.webview.b.a.n nVar) {
            if (nVar == null || nVar.type != 1) {
                return;
            }
            j.this.nM.eF.release();
            j.this.nM.fr();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.eF.a(this.mVideoPlayStateListener);
        com.kwad.components.ad.reward.d.fc().a(this.ep);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.eF.b(this.mVideoPlayStateListener);
        com.kwad.components.ad.reward.d.fc().b(this.ep);
    }
}
