package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.m.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.h.a implements com.kwad.components.core.g.kwai.a {
    public boolean hx;
    public boolean km;
    public h ko;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public k nM;
    public String uf;
    public boolean ug;
    public boolean uh;
    public List<InterfaceC0603a> ui;
    public final List<h.a> uj;
    public h.a uk;

    /* renamed from: com.kwad.components.ad.reward.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0603a {
        boolean handledOnResume();
    }

    public a(k kVar, boolean z) {
        super(kVar.mAdTemplate, kVar.mj);
        this.ug = false;
        this.uh = false;
        this.hx = false;
        this.ui = new CopyOnWriteArrayList();
        this.uj = new ArrayList();
        this.uk = new h.a() { // from class: com.kwad.components.ad.reward.j.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                a.a(a.this, true);
                if (a.this.BL != null) {
                    a.this.BL.setAudioEnabled(false);
                }
                synchronized (a.this.uj) {
                    for (h.a aVar : a.this.uj) {
                        aVar.bk();
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                synchronized (a.this.uj) {
                    for (h.a aVar : a.this.uj) {
                        aVar.bl();
                    }
                }
            }
        };
        this.nM = kVar;
        this.mContext = kVar.mContext;
        this.mVideoPlayConfig = kVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.ug = z;
        this.uf = getVideoUrl();
        aQ();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.reward.j.a.2
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                super.onVideoPlayError(i, i2);
                com.kwad.components.core.j.a.og().b(a.this.mAdTemplate, i, i2);
            }
        };
        this.ko = hVar;
        this.BL.c(hVar);
        this.BL.a(new c.e() { // from class: com.kwad.components.ad.reward.j.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                a.this.BL.start();
            }
        });
        b.at(this.mContext).a(this.uk);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.uh = true;
        return true;
    }

    private void aQ() {
        this.BL.a(new b.a(this.mAdTemplate).bk(this.uf).bl(f.b(d.bR(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            c(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.BL.prepareAsync();
    }

    private String getVideoUrl() {
        String A = com.kwad.sdk.core.response.a.a.A(d.bQ(this.mAdTemplate));
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
        return (ad == null || !ad.exists()) ? com.kwad.sdk.core.config.d.sc() > 0 ? com.kwad.sdk.core.videocache.b.a.bC(this.mContext).cA(A) : A : ad.getAbsolutePath();
    }

    private void stop() {
        pause();
        this.hx = true;
    }

    public final void a(InterfaceC0603a interfaceC0603a) {
        this.ui.add(interfaceC0603a);
    }

    @MainThread
    public final void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void a(h.a aVar) {
        this.uj.add(aVar);
    }

    public final void b(InterfaceC0603a interfaceC0603a) {
        this.ui.remove(interfaceC0603a);
    }

    @MainThread
    public final void b(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void b(h.a aVar) {
        this.uj.remove(aVar);
    }

    public final void c(boolean z, boolean z2) {
        this.km = z;
        if (!z) {
            this.BL.setVolume(0.0f, 0.0f);
            return;
        }
        this.BL.setVolume(1.0f, 1.0f);
        if (z2) {
            com.kwad.components.core.m.b.at(this.mContext).ay(true);
        }
    }

    public final long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    public final boolean iJ() {
        return this.ug;
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iK() {
        this.uh = false;
        if (this.BL.oT() == null) {
            aQ();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iL() {
        boolean z;
        loop0: while (true) {
            for (InterfaceC0603a interfaceC0603a : this.ui) {
                z = z || interfaceC0603a.handledOnResume();
            }
        }
        if (!z && !this.hx) {
            resume();
        }
        if (this.km || (com.kwad.components.ad.reward.kwai.b.fY() && this.uh)) {
            com.kwad.components.core.m.b.at(this.mContext).ay(com.kwad.components.ad.reward.kwai.b.fY());
            if (com.kwad.components.ad.reward.kwai.b.fY() && this.uh) {
                this.uh = false;
                this.km = true;
                c(true, false);
            } else if (!this.ug && com.kwad.components.core.m.b.at(this.mContext).ov()) {
                this.km = false;
                c(false, false);
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iM() {
        pause();
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void iN() {
        this.uh = false;
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.d(this.ko);
            this.BL.release();
        }
    }

    public final void pause() {
        if (k.d(this.nM)) {
            return;
        }
        this.BL.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.clear();
            this.BL.release();
        }
        com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
    }

    @Override // com.kwad.components.ad.h.a
    @WorkerThread
    public final void releaseSync() {
        super.releaseSync();
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.clear();
            this.BL.releaseSync();
        }
        com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
    }

    public final void resume() {
        this.hx = false;
        if (k.d(this.nM)) {
            return;
        }
        this.BL.resume();
    }

    @Deprecated
    public final void skipToEnd() {
        this.BL.onPlayStateChanged(9);
        stop();
    }
}
