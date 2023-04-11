package com.kwad.components.ad.draw.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes8.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public ImageView bd;
    public com.kwad.sdk.core.response.model.b be;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.b.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            if (b.this.bd.getVisibility() == 0) {
                b.this.bd.setVisibility(8);
            }
        }
    };
    public Runnable bf = new Runnable() { // from class: com.kwad.components.ad.draw.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.bd.getLayoutParams();
            int width2 = b.this.be.getWidth();
            int height = b.this.be.getHeight();
            if (width2 == 0 || height == 0 || height > width2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.bd.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.bd.setLayoutParams(layoutParams);
                b.this.bd.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            b.this.bd.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.bd, b.this.be.getUrl(), b.this.aK.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.response.model.b aL = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.bQ(this.aK.mAdTemplate));
        this.be = aL;
        if (TextUtils.isEmpty(aL.getUrl())) {
            return;
        }
        getRootView().post(this.bf);
        this.bd.setVisibility(0);
        this.aK.aL.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bd = (ImageView) findViewById(R.id.obfuscated_res_0x7f09138f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.bf);
        this.aK.aL.b(this.mVideoPlayStateListener);
    }
}
