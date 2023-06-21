package com.kwad.components.ad.e.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.ae;
/* loaded from: classes9.dex */
public final class d extends com.kwad.components.ad.e.kwai.a {
    public View jV;

    /* JADX INFO: Access modifiers changed from: private */
    public void eq() {
        if (this.jV.getVisibility() != 0) {
            return;
        }
        this.jV.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        if (ae.isNetworkConnected(this.jV.getContext())) {
            this.jV.setVisibility(8);
            return;
        }
        this.jV.setVisibility(0);
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.d.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                d.this.eq();
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                d.this.eq();
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jV = findViewById(R.id.obfuscated_res_0x7f0913f8);
    }
}
