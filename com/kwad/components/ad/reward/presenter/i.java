package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public final class i extends a {
    public com.kwad.components.ad.reward.j.a eF;
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    public final com.kwad.components.core.video.g mVideoPlayStateListener = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.presenter.i.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            i iVar = i.this;
            com.kwad.components.ad.reward.k kVar = iVar.nM;
            if (kVar.mz && kVar.mC) {
                iVar.mAdOpenInteractionListener.onVideoSkipToEnd(i.this.pQ);
            } else {
                i.this.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            e.k(i.this.nM);
            com.kwad.components.ad.reward.k kVar2 = i.this.nM;
            if (kVar2.mQ) {
                com.kwad.components.ad.reward.n.g(kVar2);
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            i.this.mAdOpenInteractionListener.onVideoPlayError(i, i2);
            i.this.gR();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            com.kwad.components.ad.reward.k kVar = i.this.nM;
            kVar.mP = j2;
            kVar.mQ = j - j2 < 800;
            i iVar = i.this;
            if (iVar.nM.mC) {
                return;
            }
            iVar.pQ = j2;
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            i.this.mAdOpenInteractionListener.onVideoPlayStart();
        }
    };
    public long pQ;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.reward.k kVar = this.nM;
        kVar.mP = 0L;
        kVar.mQ = false;
        this.mAdOpenInteractionListener = kVar.mAdOpenInteractionListener;
        com.kwad.components.ad.reward.j.a aVar = kVar.eF;
        this.eF = aVar;
        aVar.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.eF.b(this.mVideoPlayStateListener);
    }
}
