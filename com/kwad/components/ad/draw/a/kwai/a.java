package com.kwad.components.ad.draw.a.kwai;

import android.view.View;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public List<Integer> bv;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public boolean aN = false;
    public volatile boolean bw = false;
    public j bx = new j() { // from class: com.kwad.components.ad.draw.a.kwai.a.1
        @Override // com.kwad.sdk.widget.j
        public final void av() {
            k.cj(a.this.mAdTemplate);
        }
    };
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.kwai.a.2
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            com.kwad.sdk.core.report.a.ax(a.this.mAdTemplate);
            if (a.this.aK.aJ != null) {
                try {
                    a.this.aK.aJ.onVideoPlayEnd();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            if (a.this.aK.aJ != null) {
                try {
                    a.this.aK.aJ.onVideoPlayError();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            if (a.this.aK.aJ != null) {
                try {
                    a.this.aK.aJ.onVideoPlayPause();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
            a.this.aN = true;
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.c(j2);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            a.this.bw = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.aK.aJ != null) {
                a.this.aK.aJ.onAdShow();
            }
            if (a.this.aK.aJ != null) {
                try {
                    a.this.aK.aJ.onVideoPlayStart();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
                a.this.aN = false;
            }
            c.ox().a(a.this.mAdTemplate, null, null);
            com.kwad.sdk.core.report.a.aw(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            if (!a.this.aN) {
                if (a.this.bw) {
                    return;
                }
                a.this.bw = true;
                com.kwad.components.core.j.a.og().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                return;
            }
            a.this.aN = false;
            if (a.this.aK.aJ != null) {
                try {
                    a.this.aK.aJ.onVideoPlayResume();
                } catch (Throwable th) {
                    b.printStackTraceOnly(th);
                }
            }
        }
    };

    private void a(j jVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.bv;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.bv) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                this.bv.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.aK.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.bv = com.kwad.sdk.core.response.a.a.aF(bQ);
        this.aK.aL.a(this.mVideoPlayStateListener);
        a(this.bx);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aK.aL.b(this.mVideoPlayStateListener);
        a((j) null);
    }
}
