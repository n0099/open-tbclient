package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.components.core.webview.b.d.b {
    public TextView eA;
    public long eC;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.b.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            if (j2 >= b.this.eC) {
                b.this.bR();
            }
        }
    };

    private void bQ() {
        k kVar = this.nM;
        AdTemplate adTemplate = kVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = kVar.mApkDownloadHelper;
        this.eC = com.kwad.sdk.core.response.a.c.bC(adTemplate);
        this.nM.eF.a(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR() {
        if (this.eA.getVisibility() == 0) {
            return;
        }
        String bD = com.kwad.sdk.core.response.a.c.bD(this.mAdTemplate);
        if (TextUtils.isEmpty(bD)) {
            return;
        }
        this.eA.setText(bD);
        this.eA.setVisibility(0);
        this.eA.setOnClickListener(this);
        bS();
    }

    private void bS() {
        com.kwad.sdk.core.report.a.c(this.mAdTemplate, 18, this.nM.mReportExtData);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.a(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.eA) {
            this.nM.a(view2.getContext(), 40, 1, this.nM.eF.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.eA = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ba);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.eF.b(this.mVideoPlayStateListener);
        this.eA.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
