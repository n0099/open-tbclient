package com.kwad.components.ad.reward.presenter.kwai;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    public List<Integer> bv;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public final e rh = new e();
    public long mPlayTime = 0;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean ri = true;
    public volatile boolean bw = false;
    public Runnable rj = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.rh.pi()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.rh.pk();
                int pl = a.this.rh.pj().pl();
                a.this.nM.a(elapsedRealtime, a.this.rh.pj().pm(), pl);
            } else if (a.this.ri) {
                a.this.nM.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.j.a.og().Q(a.this.mAdTemplate);
        }
    };
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.2
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.rh.pg();
            a.this.mHandler.removeCallbacks(a.this.rj);
            a.this.mHandler.postDelayed(a.this.rj, 5000L);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.rh.pg();
            a.this.mHandler.removeCallbacks(a.this.rj);
            a.this.mHandler.postDelayed(a.this.rj, 5000L);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayCompleted() {
            if (!a.this.nM.mz || !a.this.nM.mC) {
                com.kwad.sdk.core.report.a.i(a.this.mAdTemplate, a.this.nM.mReportExtData);
            }
            a.this.rh.ph();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            com.kwad.components.ad.reward.monitor.a.a(a.this.nM.mz, a.this.nM.mAdTemplate, a.this.nM.mP, i, i2);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            a.this.rh.ph();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.mPlayTime = j2;
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
            f fVar;
            super.onVideoPlayStart();
            a.this.bw = false;
            EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(a.this.mAdInfo);
            if (createFromAdInfo != null) {
                fVar = new f();
                u.a aVar = new u.a();
                aVar.abz = String.valueOf(createFromAdInfo.getValue());
                fVar.a(aVar);
            } else {
                fVar = null;
            }
            c.ox().a(a.this.mAdTemplate, null, fVar);
            com.kwad.sdk.core.report.a.h(a.this.mAdTemplate, a.this.nM.mReportExtData);
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.rh.ph();
            a.b(a.this, false);
            if (a.this.bw) {
                return;
            }
            a.this.bw = true;
            com.kwad.components.core.j.a.og().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.c(a.this.nM.mz, a.this.mAdTemplate, a.this.nM.mPageEnterTime);
        }
    };

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.ri = false;
        return false;
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
                com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, this.nM.mReportExtData);
                this.bv.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.nM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.mAdInfo = bQ;
        this.bv = com.kwad.sdk.core.response.a.a.aF(bQ);
        this.nM.eF.a(this.mVideoPlayStateListener);
        this.mHandler.postDelayed(this.rj, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.nM.eF.b(this.mVideoPlayStateListener);
        e.a pj = this.rh.pj();
        com.kwad.components.core.j.a.og().a(this.nM.mAdTemplate, this.mPlayTime, pj.pm(), pj.pl());
    }
}
