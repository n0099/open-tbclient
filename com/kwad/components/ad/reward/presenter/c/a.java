package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;
/* loaded from: classes10.dex */
public final class a extends b {
    public List<Integer> cB;
    public AdInfo mAdInfo;
    public l st;
    public final i tU = new i();
    public long pl = 0;
    public Handler fS = new Handler(Looper.getMainLooper());
    public boolean tV = true;
    public volatile boolean cC = false;
    public Runnable tW = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tU.rG()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.tU.rI();
                int rJ = a.this.tU.rH().rJ();
                a.this.qn.a(elapsedRealtime, a.this.tU.rH().rK(), rJ);
            } else if (a.this.tV) {
                a.this.qn.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.o.a.pX().aw(a.this.mAdTemplate);
        }
    };
    public l su = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.hu();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tU.rF();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hO();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.c(j2);
            a.this.pl = j2;
            a.this.tU.rF();
            a.a(a.this, false);
            if (!a.this.cC) {
                a.b(a.this, true);
                com.kwad.components.core.o.a.pX().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                c.b(a.this.qn.oX, a.this.mAdTemplate, a.this.qn.mPageEnterTime);
            }
        }
    };
    public l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            a.this.hu();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tU.rF();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hO();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tU.rE();
            a.this.fS.removeCallbacks(a.this.tW);
            a.this.fS.postDelayed(a.this.tW, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tU.rE();
            a.this.fS.removeCallbacks(a.this.tW);
            a.this.fS.postDelayed(a.this.tW, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            c.a(a.this.qn.oX, a.this.qn.mAdTemplate, a.this.qn.pu, i, i2);
            com.kwad.components.ad.reward.monitor.b.c(a.this.qn.oX, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.pl = j2;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.tU.rF();
            a.a(a.this, false);
            if (!a.this.cC) {
                a.b(a.this, true);
                com.kwad.components.core.o.a.pX().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                c.b(a.this.qn.oX, a.this.mAdTemplate, a.this.qn.mPageEnterTime);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dP = e.dP(this.mAdTemplate);
        this.mAdInfo = dP;
        this.cB = com.kwad.sdk.core.response.b.a.bm(dP);
        if (this.qn.oI.jK()) {
            this.st = this.su;
        } else {
            this.st = this.gO;
        }
        this.qn.oI.a(this.st);
        this.fS.postDelayed(this.tW, 5000L);
    }

    public final void hO() {
        this.cC = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        j jVar = new j();
        if (createFromAdInfo != null) {
            y.a aVar = new y.a();
            aVar.axc = String.valueOf(createFromAdInfo.getValue());
            jVar.a(aVar);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, jVar);
        com.kwad.sdk.core.report.a.h(this.mAdTemplate, this.qn.mReportExtData);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.tV = false;
        return false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cC = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            for (Integer num : this.cB) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.a(this.mAdTemplate, ceil, this.qn.mReportExtData);
                    this.cB.remove(num);
                    return;
                }
            }
        }
    }

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j > 0 && com.kwad.sdk.core.response.b.a.ag(adInfo) > 5000) {
            this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.l.a(1, a.this.qn);
                }
            }, j);
        }
    }

    public final void hu() {
        g gVar = this.qn;
        if (!gVar.oX || !gVar.pc) {
            com.kwad.sdk.core.report.a.i(this.mAdTemplate, this.qn.mReportExtData);
        }
        this.tU.rF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fS.removeCallbacksAndMessages(null);
        this.qn.oI.b(this.st);
        i.a rH = this.tU.rH();
        com.kwad.components.core.o.a.pX().a(this.qn.mAdTemplate, this.pl, rH.rK(), rH.rJ());
    }
}
