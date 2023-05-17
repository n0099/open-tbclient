package com.kwad.components.ad.draw.a;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.utils.ae;
/* loaded from: classes9.dex */
public final class d extends com.kwad.components.ad.draw.kwai.a {
    public TextView bt;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.d.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            d.this.bt.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            d.this.bt.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlaying() {
            d.this.bt.setVisibility(8);
        }
    };

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        TextView textView;
        int i;
        super.aq();
        if (ae.isNetworkConnected(getContext())) {
            textView = this.bt;
            i = 8;
        } else {
            textView = this.bt;
            i = 0;
        }
        textView.setVisibility(i);
        this.aK.aL.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bt = (TextView) findViewById(R.id.obfuscated_res_0x7f0913d7);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aK.aL.b(this.mVideoPlayStateListener);
    }
}
