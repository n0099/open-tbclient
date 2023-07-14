package com.kwad.components.core.page.a;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a implements com.kwad.components.core.g.kwai.a {
    public b BL;
    public boolean km;
    public h ko;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public String uf;
    public boolean uh = false;
    public final List<h.a> uj = new ArrayList();
    public h.a uk = new h.a() { // from class: com.kwad.components.core.page.a.a.1
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

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        String A = com.kwad.sdk.core.response.a.a.A(d.bQ(adTemplate));
        int sc = com.kwad.sdk.core.config.d.sc();
        if (sc < 0) {
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(A);
            if (ad != null && ad.exists()) {
                A = ad.getAbsolutePath();
            }
            this.mDetailVideoView = detailVideoView;
            this.BL = new b(detailVideoView);
            aQ();
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.core.page.a.a.2
                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void onVideoPlayError(int i, int i2) {
                    super.onVideoPlayError(i, i2);
                    com.kwad.components.core.j.a.og().b(adTemplate, i, i2);
                }
            };
            this.ko = hVar;
            this.BL.c(hVar);
            this.BL.a(new c.e() { // from class: com.kwad.components.core.page.a.a.3
                @Override // com.kwad.sdk.core.video.kwai.c.e
                public final void a(c cVar) {
                    a.this.BL.start();
                }
            });
            com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
        } else if (sc != 0) {
            A = com.kwad.sdk.core.videocache.b.a.bC(detailVideoView.getContext()).cA(A);
        }
        this.uf = A;
        this.mDetailVideoView = detailVideoView;
        this.BL = new b(detailVideoView);
        aQ();
        com.kwad.components.core.video.h hVar2 = new com.kwad.components.core.video.h() { // from class: com.kwad.components.core.page.a.a.2
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                super.onVideoPlayError(i, i2);
                com.kwad.components.core.j.a.og().b(adTemplate, i, i2);
            }
        };
        this.ko = hVar2;
        this.BL.c(hVar2);
        this.BL.a(new c.e() { // from class: com.kwad.components.core.page.a.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                a.this.BL.start();
            }
        });
        com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
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

    private void c(boolean z, boolean z2) {
        com.kwad.components.core.video.b bVar;
        float f;
        this.km = z;
        if (z) {
            bVar = this.BL;
            f = 1.0f;
        } else {
            bVar = this.BL;
            f = 0.0f;
        }
        bVar.setVolume(f, f);
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.BL.pause();
    }

    private void resume() {
        this.BL.resume();
    }

    @MainThread
    public final void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    @MainThread
    public final void b(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.d(gVar);
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
        resume();
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

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.clear();
            this.BL.release();
        }
        com.kwad.components.core.m.b.at(this.mContext).b(this.uk);
    }
}
