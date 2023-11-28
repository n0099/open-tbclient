package com.kwad.components.ad.interstitial.e;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class e extends b implements a.c {
    public static long kC = 1000;
    public c jK;
    @Nullable
    public a kD;
    public int kE;
    public AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.video.a.c
    public final void bl() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public int kF;
        public boolean kG;
        public boolean kH;

        public a() {
            this.kF = Integer.MIN_VALUE;
            this.kG = false;
            this.kH = false;
        }

        public final void q(boolean z) {
            this.kH = true;
        }

        public final void r(boolean z) {
            this.kG = z;
        }

        public /* synthetic */ a(e eVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.kH) {
                return;
            }
            if (this.kG) {
                bn.a(this, null, e.kC);
                return;
            }
            if (this.kF == Integer.MIN_VALUE) {
                this.kF = e.this.kE;
            }
            if (this.kF < 0) {
                return;
            }
            com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.kF);
            e.this.D(this.kF);
            this.kF = this.kF + (-1);
            bn.a(this, null, e.kC);
        }
    }

    private void dt() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.jK.eN;
        if (aVar != null) {
            aVar.release();
        }
        this.jK.io.dismiss();
        c cVar = this.jK;
        if (!cVar.jO && (adInteractionListener = cVar.ie) != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bm() {
        if (!this.jK.cT()) {
            this.jK.b(getContext(), this.mAdTemplate);
            dt();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.b
    public final void cP() {
        super.cP();
        a aVar = this.kD;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.b
    public final void cQ() {
        super.cQ();
        a aVar = this.kD;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.jK.b(this);
        a aVar = this.kD;
        if (aVar != null) {
            aVar.q(true);
            bn.c(this.kD);
            this.kD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i) {
        c cVar = this.jK;
        com.kwad.components.ad.interstitial.g.d dVar = cVar.jL;
        if (dVar == null) {
            return;
        }
        if (i == 0) {
            if (!cVar.cT()) {
                this.jK.b(getContext(), this.mAdTemplate);
                dt();
                c cVar2 = this.jK;
                cVar2.a(true, -1, cVar2.eN);
                return;
            }
            return;
        }
        dVar.b(true, i);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void e(long j) {
        D(this.kE - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) HU();
        this.jK = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        long j = dP.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.kE = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(dP), j);
        } else {
            this.kE = com.kwad.components.ad.interstitial.b.b.b(dP);
        }
        com.kwad.components.ad.interstitial.g.d dVar = this.jK.jL;
        if (dVar != null) {
            dVar.b(true, this.kE);
        }
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            this.kD = null;
            this.jK.a(this);
            return;
        }
        a aVar = new a(this, (byte) 0);
        this.kD = aVar;
        bn.a(aVar, null, 1000L);
    }
}
