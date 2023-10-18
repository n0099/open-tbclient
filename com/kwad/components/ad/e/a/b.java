package com.kwad.components.ad.e.a;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.e.kwai.a {
    public ImageView bd;
    public com.kwad.sdk.core.response.model.b be;
    public Runnable bf = new Runnable() { // from class: com.kwad.components.ad.e.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.b.kwai.a.d(b.this.bd, b.this.be.getWidth(), b.this.be.getHeight());
            b.this.bd.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.bd, b.this.be.getUrl(), b.this.jL.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.response.model.b aL = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate));
        this.be = aL;
        if (TextUtils.isEmpty(aL.getUrl())) {
            return;
        }
        getRootView().post(this.bf);
        this.bd.setVisibility(0);
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.b.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (b.this.bd.getVisibility() == 0) {
                    b.this.bd.setVisibility(8);
                }
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bd = (ImageView) findViewById(R.id.obfuscated_res_0x7f091451);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.bf);
    }
}
