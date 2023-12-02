package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    public com.kwad.components.ad.k.b ci;
    public FrameLayout da;
    public DetailVideoView mDetailVideoView;
    public int tf = Integer.MIN_VALUE;
    public final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.ci != null && g.G(c.this.qn.mAdTemplate)) {
                c.this.ci.ag(true);
            }
        }
    };
    public com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.qn.oH.bJ();
        }
    };

    @Override // com.kwad.components.ad.k.b.a
    public final void iy() {
        hn();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.da = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091515);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.obfuscated_res_0x7f091500);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        com.kwad.components.ad.k.b bVar = this.ci;
        if (bVar != null) {
            bVar.mc();
            this.ci.lP();
        }
        com.kwad.components.ad.reward.b.fa().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null && (i = this.tf) != Integer.MIN_VALUE) {
            com.kwad.sdk.d.a.a.n(detailVideoView, i);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        g gVar = this.qn;
        AdTemplate adTemplate = gVar.mAdTemplate;
        j jVar = gVar.oM;
        this.ci = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.fa().a(this.mRewardVerifyListener);
        this.ci.a(this.cR);
        com.kwad.components.ad.k.b bVar = this.ci;
        FrameLayout frameLayout = this.da;
        g gVar2 = this.qn;
        bVar.a(frameLayout, gVar2.mRootContainer, adTemplate, gVar2.mApkDownloadHelper, gVar2.mScreenOrientation);
        this.ci.a((b.InterfaceC0606b) null);
        com.kwad.components.ad.k.b bVar2 = this.ci;
        if (bVar2 != null) {
            bVar2.a(this);
        }
    }
}
