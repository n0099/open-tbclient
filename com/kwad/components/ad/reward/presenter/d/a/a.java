package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.k.a;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements a.b {
    public FrameLayout da;
    public l st;
    public volatile long vy = 0;
    public volatile boolean vz = false;
    public l su = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            a.this.vz = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.vz = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.vz = false;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.vy = j2;
        }
    };
    public l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            boolean z;
            super.onMediaPlayProgress(j, j2);
            a.this.vy = j2;
            a aVar = a.this;
            if (j - j2 < 800) {
                z = true;
            } else {
                z = false;
            }
            aVar.vz = z;
        }
    };
    public g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (!a.this.qn.po && a.this.qn.oN != null) {
                a.this.qn.oN.ar();
            }
        }
    };
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.5
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            a.this.qn.oH.bJ();
        }
    };

    @Override // com.kwad.components.ad.k.a.b
    public final void it() {
        f.r(this.qn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.da = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0913aa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.c(this.mPlayEndPageListener);
        this.qn.oI.b(this.st);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        l lVar;
        super.aj();
        this.vy = 0L;
        this.vz = false;
        com.kwad.components.ad.reward.g gVar = this.qn;
        AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.k.a aVar = gVar.oN;
        if (gVar.oI.jK()) {
            lVar = this.su;
        } else {
            lVar = this.gO;
        }
        this.st = lVar;
        if (aVar != null) {
            this.qn.pi = true;
            aVar.a(this);
            aVar.a(this.cR);
            aVar.a(this.da, this.qn.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0604a() { // from class: com.kwad.components.ad.reward.presenter.d.a.a.3
                @Override // com.kwad.components.ad.k.a.InterfaceC0604a
                public final void R(boolean z) {
                    a.this.qn.pi = z;
                }
            });
            aVar.setActivity(this.qn.getActivity());
            aVar.ay();
            this.qn.b(this.mPlayEndPageListener);
            this.qn.oI.a(this.st);
        }
    }
}
