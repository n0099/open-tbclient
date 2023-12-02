package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public final class p extends b {
    public com.kwad.components.core.playable.a oK;
    public PlayableSource sH;
    public final com.kwad.components.ad.reward.e.j sI = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            boolean z;
            p.this.sH = playableSource;
            if (p.this.oK != null && p.this.oK.pU()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                p.this.oK.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.qn;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.qn.B(true);
                    if (p.this.qn.oI.jK()) {
                        p.this.qn.oI.jL().pause();
                    }
                }
                com.kwad.components.ad.reward.a.eW().b(playableSource);
                return;
            }
            if (p.this.oK != null) {
                p.this.oK.hx();
            }
            if (nVar != null) {
                nVar.gR();
                com.kwad.sdk.core.e.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(p.this.qn.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.qn.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void bY() {
            p.this.oK.hx();
            com.kwad.components.ad.reward.g gVar = p.this.qn;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.qn.oI.jK()) {
                    p.this.qn.oI.jL().resume();
                }
            }
        }
    };

    public final void hx() {
        com.kwad.components.core.playable.a aVar = this.oK;
        if (aVar != null) {
            aVar.hx();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0913ff)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.oK;
        if (aVar == null) {
            return;
        }
        aVar.pS();
        this.oK.hx();
        com.kwad.components.ad.reward.a.eW().b(this.sI);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.oK;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.sH);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qn;
        com.kwad.components.core.playable.a aVar = gVar.oK;
        this.oK = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar.mAdTemplate, gVar.mRootContainer, gVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.qn.oX, "playable");
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        com.kwad.components.ad.reward.g gVar2 = this.qn;
        com.kwad.components.ad.reward.monitor.c.a(gVar2.mAdTemplate, gVar2.oX, "playable", com.kwad.sdk.core.response.b.a.bN(dP));
        this.oK.pT();
        this.oK.a(new aq.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                if (!aVar2.isSuccess()) {
                    AdInfo dP2 = com.kwad.sdk.core.response.b.e.dP(p.this.qn.mAdTemplate);
                    long loadTime = p.this.qn.oK.getLoadTime();
                    if (loadTime == -1) {
                        return;
                    }
                    com.kwad.components.ad.reward.g gVar3 = p.this.qn;
                    com.kwad.components.ad.reward.monitor.c.a(gVar3.mAdTemplate, gVar3.oX, "playable", com.kwad.sdk.core.response.b.a.bN(dP2), System.currentTimeMillis() - loadTime, 3);
                }
            }
        });
        this.oK.a(new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                AdInfo dP2 = com.kwad.sdk.core.response.b.e.dP(p.this.qn.mAdTemplate);
                long loadTime = p.this.qn.oK.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.qn.oX, "playable", com.kwad.sdk.core.response.b.a.bN(dP2), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.g gVar3 = p.this.qn;
                AdTemplate adTemplate = gVar3.mAdTemplate;
                com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar3.oX, "playable", com.kwad.sdk.core.response.b.a.bN(com.kwad.sdk.core.response.b.e.dP(adTemplate)), System.currentTimeMillis() - p.this.qn.oK.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.a.eW().a(this.sI);
    }
}
