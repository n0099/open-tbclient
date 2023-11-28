package com.kwad.components.ad.f.b;

import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class k extends com.kwad.components.ad.f.a.a {
    public ProgressBar nl;

    /* JADX INFO: Access modifiers changed from: private */
    public void eA() {
        if (this.nl.getVisibility() != 0) {
            return;
        }
        this.nl.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.nl.setProgress(0);
        this.nl.setVisibility(8);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.k.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                k.this.eA();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                k.this.eA();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                int i;
                if (j != 0) {
                    i = (int) ((((float) j2) * 100.0f) / ((float) j));
                } else {
                    i = 0;
                }
                k.this.H(i);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nl = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i) {
        this.nl.setProgress(i);
        if (this.nl.getVisibility() == 0) {
            return;
        }
        this.nl.setVisibility(0);
    }
}
