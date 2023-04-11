package com.kwad.components.ad.e.a;

import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public final class k extends com.kwad.components.ad.e.kwai.a {
    public ProgressBar kk;

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i) {
        this.kk.setProgress(i);
        if (this.kk.getVisibility() == 0) {
            return;
        }
        this.kk.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        if (this.kk.getVisibility() != 0) {
            return;
        }
        this.kk.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.kk.setProgress(0);
        this.kk.setVisibility(8);
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.k.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                k.this.ev();
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                k.this.ev();
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                k.this.H(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kk = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091398);
    }
}
