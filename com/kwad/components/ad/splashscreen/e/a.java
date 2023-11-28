package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a extends b implements c {
    public boolean Fl;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public boolean nn;
    public String xK;
    public final List<h.a> xN;
    public OfflineOnAudioConflictListener xP;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.xN = new ArrayList();
        this.xP = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.e.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.xN) {
                    for (h.a aVar : a.this.xN) {
                        aVar.onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xN) {
                    for (h.a aVar : a.this.xN) {
                        aVar.onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String aZ = com.kwad.sdk.core.response.b.a.aZ(e.dP(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(aZ);
        if (bO != null && bO.exists()) {
            this.xK = bO.getAbsolutePath();
        }
        this.Hr.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.e.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.e.a.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean a = bq.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.e.c.d("SplashPlayModule", " onPrepared" + a);
                        if (a) {
                            a.this.Hr.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xP);
    }

    public final void ae(boolean z) {
        this.Fl = true;
    }

    private void aL() {
        this.Hr.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).cD(this.xK).cE(com.kwad.sdk.core.response.b.h.b(e.dQ(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate)).Ah(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hr.prepareAsync();
    }

    public final void a(h.a aVar) {
        this.xN.add(aVar);
    }

    public final void b(h.a aVar) {
        this.xN.remove(aVar);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        resume();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        pause();
    }

    public final long getCurrentPosition() {
        return this.Hr.getCurrentPosition();
    }

    public final void lH() {
        if (this.Hr.rf() == null) {
            aL();
        }
        this.Hr.start();
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void release() {
        super.release();
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xP);
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        super.resume();
        if (this.nn && this.Fl) {
            com.kwad.components.core.s.a.ah(this.mContext).aM(false);
            if (com.kwad.components.core.s.a.ah(this.mContext).qJ()) {
                this.nn = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.j.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.nn = z;
        if (z && z2) {
            com.kwad.components.core.s.a.ah(this.mContext).aM(true);
        }
        this.Hr.setAudioEnabled(z);
    }
}
