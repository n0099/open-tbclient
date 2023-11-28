package com.kwad.components.ad.draw.b.a;

import android.view.View;
import com.kwad.components.core.s.b;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.draw.a.a {
    public List<Integer> cB;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public boolean bR = false;
    public volatile boolean cC = false;
    public j cD = new j() { // from class: com.kwad.components.ad.draw.b.a.a.1
        @Override // com.kwad.sdk.widget.j
        public final void ao() {
            l.ek(a.this.mAdTemplate);
        }
    };
    public k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.draw.b.a.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            com.kwad.sdk.core.report.a.bO(a.this.mAdTemplate);
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayPause();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
            a.this.bR = true;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayError();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            a.this.cC = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.bO.bN != null) {
                a.this.bO.bN.onAdShow();
            }
            if (a.this.bO.bN != null) {
                try {
                    a.this.bO.bN.onVideoPlayStart();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
                a.this.bR = false;
            }
            b.qL().a(a.this.mAdTemplate, null, null);
            com.kwad.sdk.core.report.a.bN(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.bR) {
                a.this.bR = false;
                if (a.this.bO.bN != null) {
                    try {
                        a.this.bO.bN.onVideoPlayResume();
                    } catch (Throwable th) {
                        c.printStackTraceOnly(th);
                    }
                }
            } else if (a.this.cC) {
            } else {
                a.this.cC = true;
                com.kwad.components.core.o.a.pX().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        }
    };

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dP = e.dP(adTemplate);
        this.mAdInfo = dP;
        this.cB = com.kwad.sdk.core.response.b.a.bm(dP);
        this.bO.bP.b(this.mVideoPlayStateListener);
        a(this.cD);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.bP.a(this.mVideoPlayStateListener);
        a((j) null);
    }

    private void a(j jVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            for (Integer num : this.cB) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, (JSONObject) null);
                    this.cB.remove(num);
                    return;
                }
            }
        }
    }
}
