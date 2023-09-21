package com.kwad.components.ad.e.a;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public final class g extends com.kwad.components.ad.e.kwai.a {
    public ImageView kc;

    /* JADX INFO: Access modifiers changed from: private */
    public void es() {
        KSImageLoader.loadImage(this.kc, com.kwad.sdk.core.response.a.a.K(com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate)), this.jL.mAdTemplate);
        this.kc.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.g.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                g.this.es();
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
        this.kc.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kc = (ImageView) findViewById(R.id.obfuscated_res_0x7f091435);
    }
}
