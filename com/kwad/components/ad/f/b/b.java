package com.kwad.components.ad.f.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.f.a.a {
    public ImageView ck;
    public com.kwad.sdk.core.response.model.b cl;
    public Runnable cm = new Runnable() { // from class: com.kwad.components.ad.f.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.d.a.a.d(b.this.ck, b.this.cl.getWidth(), b.this.cl.getHeight());
            b.this.ck.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.ck, b.this.cl.getUrl(), b.this.mM.mAdTemplate);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ck = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f6);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.cm);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.response.model.b br = com.kwad.sdk.core.response.b.a.br(com.kwad.sdk.core.response.b.e.dP(this.mM.mAdTemplate));
        this.cl = br;
        if (TextUtils.isEmpty(br.getUrl())) {
            return;
        }
        getRootView().post(this.cm);
        this.ck.setVisibility(0);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.b.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (b.this.ck.getVisibility() == 0) {
                    b.this.ck.setVisibility(8);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }
}
