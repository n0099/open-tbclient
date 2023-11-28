package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.j.b implements g.a {
    public boolean kH;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public boolean nn;
    public l np;
    public g qn;
    public String xK;
    public AtomicBoolean xL;
    public boolean xM;
    public final List<h.a> xN;
    public final List<Object> xO;
    public OfflineOnAudioConflictListener xP;

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.xL = new AtomicBoolean(false);
        this.xM = false;
        this.kH = false;
        this.xN = new ArrayList();
        this.xO = new ArrayList();
        this.xP = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.Hr != null) {
                    d.this.Hr.setAudioEnabled(false);
                }
                synchronized (d.this.xN) {
                    for (h.a aVar : d.this.xN) {
                        aVar.onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (d.this.xN) {
                    for (h.a aVar : d.this.xN) {
                        aVar.onAudioBeReleased();
                    }
                }
            }
        };
        this.qn = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xK = getVideoUrl();
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.xM = true;
        return true;
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.nn = z;
        if (this.xL.get() && this.Hr != null) {
            if (z && z2) {
                com.kwad.components.core.s.a.ah(this.mContext).aM(true);
            }
            this.Hr.setAudioEnabled(z);
        }
    }

    private void aL() {
        if (jI()) {
            return;
        }
        this.Hr.a(new b.a(this.mAdTemplate).cD(this.xK).cE(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dQ(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate)).Ah(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hr.prepareAsync();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fT() {
        if (this.kH) {
            return;
        }
        resume();
        if (this.nn || (com.kwad.components.ad.reward.a.b.gq() && this.xM)) {
            com.kwad.components.core.s.a.ah(this.mContext).aM(com.kwad.components.ad.reward.a.b.gq());
            if (com.kwad.components.ad.reward.a.b.gq() && this.xM) {
                this.xM = false;
                this.nn = true;
                setAudioEnabled(true, false);
            } else if (!this.qn.oG && com.kwad.components.core.s.a.ah(this.mContext).qJ()) {
                this.nn = false;
                setAudioEnabled(false, false);
            }
        }
    }

    private String getVideoUrl() {
        if (jI()) {
            return "";
        }
        return j.f(this.mContext, this.mAdTemplate);
    }

    private boolean jI() {
        if (com.kwad.sdk.core.response.b.a.cJ(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))) {
            return true;
        }
        return false;
    }

    private void stop() {
        pause();
        this.kH = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fS() {
        this.xM = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fU() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        com.kwad.components.core.video.b bVar;
        this.xM = false;
        if (this.xL.get() && (bVar = this.Hr) != null) {
            bVar.d(this.np);
            this.Hr.release();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final long getPlayDuration() {
        if (this.xL.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    public final void jH() {
        Iterator<Object> it = this.xO.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void pause() {
        if (this.xL.get() && this.Hr != null && !jI()) {
            super.pause();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xP);
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        this.kH = false;
        if (!this.xL.get() || this.Hr == null || jI() || g.b(this.qn)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.j.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (this.xL.get() && (bVar = this.Hr) != null) {
            bVar.onPlayStateChanged(9);
            stop();
        }
    }

    public final void a(h.a aVar) {
        this.xN.add(aVar);
    }

    public final void b(h.a aVar) {
        this.xN.remove(aVar);
    }

    public final void jG() {
        if (this.xL.get()) {
            return;
        }
        this.xL.set(true);
        aL();
        l lVar = new l() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.pX().c(d.this.mAdTemplate, i, i2);
            }
        };
        this.np = lVar;
        this.Hr.c(lVar);
        this.Hr.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.c.b.Ct();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    d.this.Hr.start();
                }
            }
        });
        this.Hr.start();
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xP);
    }
}
