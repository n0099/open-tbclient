package com.kwad.components.ad.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.d.e;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.page.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements c.a {
    public ComplianceTextView bc;
    public AdBaseFrameLayout ct;
    public com.kwad.components.core.page.c landingPageViewHelper;
    public AdTemplate mAdTemplate;
    public FrameLayout sr;
    public volatile long ss = 0;
    public volatile boolean st = false;
    public final g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            a.this.ss = j2;
            a.this.st = j - j2 < 800;
        }
    };
    public final e mPlayEndPageListener = new e() { // from class: com.kwad.components.ad.reward.presenter.a.kwai.a.2
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            if (a.this.nM.mJ || a.this.sr == null || a.this.landingPageViewHelper == null || !a.this.landingPageViewHelper.ny()) {
                return;
            }
            a.this.bc.setVisibility(8);
            a.this.sr.setVisibility(0);
            a.this.landingPageViewHelper.show();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.mAdTemplate = this.nM.mAdTemplate;
        if (this.landingPageViewHelper == null) {
            com.kwad.components.core.page.c cVar = new com.kwad.components.core.page.c(getContext(), this.mAdTemplate, 4, false);
            this.landingPageViewHelper = cVar;
            cVar.a(this);
            this.landingPageViewHelper.a(new c.C0656c().at(false).as(true).aq("").ar(com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)).nI());
            this.sr.addView(this.landingPageViewHelper.getRootView());
        }
        this.ss = 0L;
        this.st = false;
        k kVar = this.nM;
        this.ct = kVar.mRootContainer;
        kVar.a(this.mPlayEndPageListener);
        this.nM.eF.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onBackBtnClicked(View view2) {
        k kVar = this.nM;
        if (kVar.mAdOpenInteractionListener != null) {
            long T2 = com.kwad.sdk.core.response.a.a.T(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate));
            boolean z = true;
            if (T2 >= 0 && !this.st && this.ss < T2) {
                z = false;
            }
            if (z) {
                this.nM.mAdOpenInteractionListener.onRewardVerify();
            }
        }
        this.nM.mAdOpenInteractionListener.j(false);
        gR();
    }

    @Override // com.kwad.components.core.page.c.a
    public final void onCloseBtnClicked(View view2) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sr = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0912e8);
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0912a8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.page.c cVar = this.landingPageViewHelper;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this.mPlayEndPageListener);
        this.nM.eF.b(this.mVideoPlayStateListener);
    }
}
