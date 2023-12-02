package com.kwad.components.ad.f.b;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.f.a.a {
    public View mW;

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        if (this.mW.getVisibility() != 0) {
            return;
        }
        this.mW.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (ag.isNetworkConnected(this.mW.getContext())) {
            this.mW.setVisibility(8);
            return;
        }
        this.mW.setVisibility(0);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.d.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.ev();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.ev();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mW = findViewById(R.id.obfuscated_res_0x7f0914fc);
    }
}
