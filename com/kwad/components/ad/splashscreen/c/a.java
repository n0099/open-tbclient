package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.h.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.h.a implements b {
    public boolean km;
    public Bitmap mBitmap;
    public Context mContext;
    public KsVideoPlayConfig mVideoPlayConfig;
    public VideoPlayerStatus mVideoPlayerStatus;
    public String uf;
    public final List<h.a> uj;
    public h.a uk;
    public boolean zJ;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.uj = new ArrayList();
        this.uk = new h.a() { // from class: com.kwad.components.ad.splashscreen.c.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
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
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String az = com.kwad.sdk.core.response.a.a.az(d.bQ(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(az);
        if (ad != null && ad.exists()) {
            this.uf = ad.getAbsolutePath();
        }
        this.BL.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.c.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                boolean a = com.kwad.sdk.b.kwai.a.a((View) detailVideoView, 50, true);
                com.kwad.sdk.core.e.b.d("SplashPlayModule", " onPrepared" + a);
                if (a) {
                    a.this.BL.start();
                }
            }
        });
        com.kwad.components.core.m.b.at(this.mContext).a(this.uk);
    }

    private void aQ() {
        this.BL.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).bk(this.uf).bl(f.b(d.bR(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            c(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.BL.prepareAsync();
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

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        resume();
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        pause();
    }

    public final void ad(boolean z) {
        this.zJ = true;
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

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final long getCurrentPosition() {
        return this.BL.getCurrentPosition();
    }

    public final void kA() {
        if (this.BL.oT() == null) {
            aQ();
        }
        this.BL.start();
    }

    public final TextureView ky() {
        return this.mDetailVideoView.Kb;
    }

    @MainThread
    public final void kz() {
        com.kwad.components.core.video.b bVar = this.BL;
        if (bVar != null) {
            bVar.clear();
            this.BL.pause();
        }
    }

    public final void pause() {
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

    public final void resume() {
        this.BL.resume();
        if (this.km && this.zJ) {
            com.kwad.components.core.m.b.at(this.mContext).ay(false);
            if (com.kwad.components.core.m.b.at(this.mContext).ov()) {
                this.km = false;
                c(false, false);
            }
        }
    }
}
