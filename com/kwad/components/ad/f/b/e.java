package com.kwad.components.ad.f.b;

import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes10.dex */
public final class e extends com.kwad.components.ad.f.a.a {
    public boolean bR = false;
    public KsNativeAd.VideoPlayListener mq;

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mq = this.mM.mq;
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.e.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.mq != null) {
                    try {
                        e.this.mq.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
                e.this.bR = true;
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (!e.this.bR) {
                    return;
                }
                e.this.bR = false;
                if (e.this.mq != null) {
                    try {
                        e.this.mq.onVideoPlayResume();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.mq != null) {
                    try {
                        e.this.mq.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                if (e.this.mq != null) {
                    e.this.mq.onVideoPlayError(i, i2);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
