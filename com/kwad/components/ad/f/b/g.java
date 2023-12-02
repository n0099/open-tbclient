package com.kwad.components.ad.f.b;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public final class g extends com.kwad.components.ad.f.a.a {
    public ImageView nd;

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        KSImageLoader.loadImage(this.nd, com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.e.dP(this.mM.mAdTemplate)), this.mM.mAdTemplate);
        this.nd.setVisibility(0);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.g.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                g.this.ex();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
        this.nd.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nd = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f4);
    }
}
