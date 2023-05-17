package com.kwad.components.ad.fullscreen.b.kwai;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.b.d.b {
    public TextView ey;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.fullscreen.b.kwai.a.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.x((int) ((((float) (j - j2)) / 1000.0f) + 0.5f));
        }
    };

    private void bQ() {
        this.ey.setText(String.valueOf(com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate))));
        this.ey.setVisibility(0);
        this.nM.eF.a(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.ey.setText(String.valueOf(i));
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (k.b(this.nM)) {
            com.kwad.components.core.webview.b.c.a.pR().a(this);
        } else {
            bQ();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ey = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d3);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this);
        this.nM.eF.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.core.webview.b.d.b
    public final void u(String str) {
        if ("ksad-video-top-bar".equals(str)) {
            bQ();
        }
    }
}
