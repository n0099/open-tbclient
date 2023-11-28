package com.kwad.components.ad.f.b;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class j extends com.kwad.components.ad.f.a.a {
    public View nj;

    /* JADX INFO: Access modifiers changed from: private */
    public void ez() {
        if (this.nj.getVisibility() == 0) {
            return;
        }
        this.nj.setVisibility(0);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.nj.setVisibility(8);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.j.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                j.this.ez();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nj = findViewById(R.id.obfuscated_res_0x7f0914f4);
    }
}
