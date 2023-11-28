package com.kwad.components.ad.draw.b;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.draw.a.a {
    public TextView cz;
    public k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            d.this.cz.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.cz.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            d.this.cz.setVisibility(8);
        }
    };

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!ag.isNetworkConnected(getContext())) {
            this.cz.setVisibility(0);
        } else {
            this.cz.setVisibility(8);
        }
        this.bO.bP.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.bP.a(this.mVideoPlayStateListener);
    }
}
