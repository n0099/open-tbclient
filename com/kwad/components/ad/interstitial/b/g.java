package com.kwad.components.ad.interstitial.b;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes9.dex */
public final class g extends b implements a.b {
    public static long hs = 1000;
    public c gh;
    @Nullable
    public a ht;
    public int hu;
    public AdTemplate mAdTemplate;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public int hv;
        public boolean hw;
        public boolean hx;

        public a() {
            this.hv = Integer.MIN_VALUE;
            this.hw = false;
            this.hx = false;
        }

        public /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void q(boolean z) {
            this.hx = true;
        }

        public final void r(boolean z) {
            this.hw = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.hx) {
                return;
            }
            if (!this.hw) {
                if (this.hv == Integer.MIN_VALUE) {
                    this.hv = g.this.hu;
                }
                if (this.hv < 0) {
                    return;
                }
                com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", g.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.hv);
                g.this.D(this.hv);
                this.hv = this.hv + (-1);
            }
            bd.a(this, null, g.hs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i) {
        c cVar = this.gh;
        com.kwad.components.ad.interstitial.widget.f fVar = cVar.gj;
        if (fVar == null) {
            return;
        }
        if (i != 0) {
            fVar.b(true, i);
        } else if (cVar.cB()) {
        } else {
            this.gh.b(getContext(), this.mAdTemplate);
            cY();
            c cVar2 = this.gh;
            cVar2.a(true, -1, cVar2.dp);
        }
    }

    private void cY() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
        if (aVar != null) {
            aVar.release();
        }
        this.gh.gi.dismiss();
        c cVar = this.gh;
        if (cVar.gn || (adInteractionListener = cVar.fo) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) xR();
        this.gh = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        long j = bQ.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.hu = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.b(bQ), j);
        } else {
            this.hu = com.kwad.components.ad.interstitial.kwai.b.b(bQ);
        }
        com.kwad.components.ad.interstitial.widget.f fVar = this.gh.gj;
        if (fVar != null) {
            fVar.b(true, -1);
        }
        if (!com.kwad.sdk.core.response.a.a.aB(bQ)) {
            a aVar = new a(this, (byte) 0);
            this.ht = aVar;
            bd.a(aVar, null, 1000L);
            return;
        }
        this.hu = (int) Math.min(this.hu, com.kwad.sdk.core.response.a.a.B(bQ));
        this.ht = null;
        this.gh.a(this);
    }

    @Override // com.kwad.components.core.video.a.b
    public final void bm() {
        if (this.gh.cB()) {
            return;
        }
        this.gh.b(getContext(), this.mAdTemplate);
        cY();
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        super.cv();
        a aVar = this.ht;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        super.cw();
        a aVar = this.ht;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void d(long j) {
        D(this.hu - ((int) (j / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.b.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.gh.b(this);
        a aVar = this.ht;
        if (aVar != null) {
            aVar.q(true);
            bd.c(this.ht);
            this.ht = null;
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.components.core.video.a.b
    public final void onVideoPlaying() {
    }
}
