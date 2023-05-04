package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class l extends a {
    public com.kwad.components.core.playable.a mk;
    public PlayableSource qe;
    public final com.kwad.components.ad.reward.d.f qf = new com.kwad.components.ad.reward.d.g() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.ad.reward.d.g, com.kwad.components.ad.reward.d.f
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
            l.this.qe = playableSource;
            if (l.this.mk != null && l.this.mk.od()) {
                l.this.mk.e(playableSource);
                com.kwad.components.ad.reward.k kVar = l.this.nM;
                if (kVar != null) {
                    kVar.d(playableSource);
                    l.this.nM.E(true);
                    l.this.nM.eF.pause();
                }
                com.kwad.components.ad.reward.b.eV().b(playableSource);
                return;
            }
            if (l.this.mk != null) {
                l.this.mk.ha();
            }
            if (jVar != null) {
                jVar.gv();
                com.kwad.sdk.core.e.b.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(l.this.nM.mAdTemplate))) {
                DownloadLandPageActivity.launch(l.this.getActivity(), l.this.nM.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.d.g, com.kwad.components.ad.reward.d.f
        public final void bO() {
            l.this.mk.ha();
            com.kwad.components.ad.reward.k kVar = l.this.nM;
            if (kVar != null) {
                kVar.d((PlayableSource) null);
                l.this.nM.eF.resume();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.reward.k kVar = this.nM;
        com.kwad.components.core.playable.a aVar = kVar.mk;
        this.mk = aVar;
        aVar.a(kVar.mAdTemplate, kVar.mRootContainer, kVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "playable");
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate)));
        this.mk.oc();
        this.mk.a(new x.b() { // from class: com.kwad.components.ad.reward.presenter.l.2
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(l.this.nM.mAdTemplate);
                long loadTime = l.this.nM.mk.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.a(l.this.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(bQ), System.currentTimeMillis() - loadTime);
            }
        });
        this.mk.a(new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.l.3
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(l.this.nM.mAdTemplate);
                long loadTime = l.this.nM.mk.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.b(l.this.nM.mz, "playable", com.kwad.sdk.core.response.a.a.bc(bQ), System.currentTimeMillis() - loadTime);
            }
        });
        com.kwad.components.ad.reward.b.eV().a(this.qf);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.mk;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.qe);
            }
        }
    }

    public final void ha() {
        com.kwad.components.core.playable.a aVar = this.mk;
        if (aVar != null) {
            aVar.ha();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0912b0)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mk.ob();
        this.mk.ha();
        com.kwad.components.ad.reward.b.eV().b(this.qf);
    }
}
