package com.kwad.components.ad.reward.presenter.a.kwai;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.i.a;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements a.b {
    public FrameLayout bS;
    public volatile long ss = 0;
    public volatile boolean st = false;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.b.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            b.this.ss = j2;
            b.this.st = j - j2 < 800;
        }
    };
    public e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.b.3
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            if (b.this.nM.mJ || b.this.nM.mo == null) {
                return;
            }
            b.this.nM.mo.ay();
        }
    };
    public com.kwad.sdk.core.webview.a.kwai.a bJ = new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.b.4
        @Override // com.kwad.sdk.core.webview.a.kwai.a
        public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            b.this.nM.mAdOpenInteractionListener.bB();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.ss = 0L;
        this.st = false;
        k kVar = this.nM;
        AdTemplate adTemplate = kVar.mAdTemplate;
        com.kwad.components.ad.i.a aVar = kVar.mo;
        if (aVar != null) {
            kVar.mF = true;
            aVar.a(this);
            aVar.a(this.bJ);
            aVar.a(this.bS, this.nM.mRootContainer, adTemplate);
            aVar.a(new a.InterfaceC0604a() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.b.2
                @Override // com.kwad.components.ad.i.a.InterfaceC0604a
                public final void V(boolean z) {
                    b.this.nM.mF = z;
                }
            });
            aVar.setActivity(this.nM.getActivity());
            aVar.aE();
            this.nM.a(this.mPlayEndPageListener);
            this.nM.eF.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.components.ad.i.a.b
    public final void hI() {
        k kVar = this.nM;
        com.kwad.components.ad.reward.presenter.e.a(kVar, kVar.fC());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bS = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091311);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this.mPlayEndPageListener);
        this.nM.eF.b(this.mVideoPlayStateListener);
    }
}
