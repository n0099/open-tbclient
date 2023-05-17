package com.kwad.components.ad.fullscreen.b;

import com.kwad.components.ad.reward.d;
import com.kwad.components.ad.reward.d.i;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.b.a.n;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.fullscreen.b.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            a.this.nM.fr();
        }
    };
    public final i ep = new i() { // from class: com.kwad.components.ad.fullscreen.b.a.2
        @Override // com.kwad.components.ad.reward.d.i
        public final void a(n nVar) {
            if (nVar == null || nVar.type != 1) {
                return;
            }
            a.this.nM.eF.release();
            a.this.nM.fr();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.eF.a(this.mVideoPlayStateListener);
        d.fc().a(this.ep);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.eF.b(this.mVideoPlayStateListener);
        d.fc().b(this.ep);
    }
}
