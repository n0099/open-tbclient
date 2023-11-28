package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class m extends b {
    public long hj;
    @NonNull
    public com.kwad.components.ad.reward.e.b oH;
    public com.kwad.components.core.video.l st;
    public com.kwad.components.core.video.l su = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qn;
            if (gVar.oX && gVar.pc) {
                mVar.oH.onVideoSkipToEnd(m.this.hj);
            } else {
                m mVar2 = m.this;
                mVar2.qn.pv = true;
                mVar2.oH.onVideoPlayEnd();
            }
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(m.this.qn.mAdTemplate);
            if (!com.kwad.sdk.core.response.b.a.aO(dP) || com.kwad.sdk.core.response.b.a.aN(dP) != 1) {
                f.s(m.this.qn);
                com.kwad.components.ad.reward.g gVar2 = m.this.qn;
                if (gVar2.pv) {
                    com.kwad.components.ad.reward.k.h(gVar2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qn;
            gVar.pu = j2;
            if (!gVar.pc) {
                mVar.hj = j2;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.oH.onVideoPlayStart();
            m.this.qn.pv = false;
        }
    };
    public final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.qn.pc) {
                mVar.oH.onVideoSkipToEnd(m.this.hj);
            } else {
                mVar.oH.onVideoPlayEnd();
            }
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(m.this.qn.mAdTemplate);
            if (!com.kwad.sdk.core.response.b.a.aO(dP) || com.kwad.sdk.core.response.b.a.aN(dP) != 1) {
                f.s(m.this.qn);
                com.kwad.components.ad.reward.g gVar = m.this.qn;
                if (gVar.pv) {
                    com.kwad.components.ad.reward.k.h(gVar);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            m.this.oH.onVideoPlayError(i, i2);
            m.this.hn();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            boolean z;
            com.kwad.components.ad.reward.g gVar = m.this.qn;
            gVar.pu = j2;
            if (j - j2 < 800) {
                z = true;
            } else {
                z = false;
            }
            gVar.pv = z;
            m mVar = m.this;
            if (!mVar.qn.pc) {
                mVar.hj = j2;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.oH.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qn;
        gVar.pu = 0L;
        gVar.pv = false;
        this.oH = gVar.oH;
        if (gVar.oI.jK()) {
            this.st = this.su;
        } else {
            this.st = this.gO;
        }
        this.qn.oI.a(this.st);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.oI.b(this.st);
    }
}
