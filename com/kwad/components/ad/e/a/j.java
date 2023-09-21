package com.kwad.components.ad.e.a;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class j extends com.kwad.components.ad.e.kwai.a {
    public View ki;

    /* JADX INFO: Access modifiers changed from: private */
    public void eu() {
        if (this.ki.getVisibility() == 0) {
            return;
        }
        this.ki.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.ki.setVisibility(8);
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.j.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                j.this.eu();
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ki = findViewById(R.id.obfuscated_res_0x7f091436);
    }
}
