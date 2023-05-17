package com.kwad.components.ad.e.a;

import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes9.dex */
public final class e extends com.kwad.components.ad.e.kwai.a {
    public boolean aN = false;
    public KsNativeAd.VideoPlayListener jA;

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.jA = this.jL.jA;
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.e.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                if (e.this.jA != null) {
                    e.this.jA.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                if (e.this.jA != null) {
                    e.this.jA.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                if (e.this.jA != null) {
                    try {
                        e.this.jA.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    }
                }
                e.this.aN = true;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                if (e.this.jA != null) {
                    e.this.jA.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (e.this.aN) {
                    e.this.aN = false;
                    if (e.this.jA != null) {
                        try {
                            e.this.jA.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPrepared() {
                super.onVideoPrepared();
                if (e.this.jA != null) {
                    try {
                        e.this.jA.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }
}
