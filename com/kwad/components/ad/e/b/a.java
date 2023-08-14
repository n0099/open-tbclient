package com.kwad.components.ad.e.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.k;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.h.a {
    public b aM;
    public final com.kwad.sdk.core.h.b bX;
    public KsAdVideoPlayConfig cN;
    public boolean dt;
    public h.a dv;
    public boolean hasNoCache;
    public boolean km;
    public boolean kn;
    public com.kwad.components.core.video.h ko;
    public final AdInfo mAdInfo;
    public Context mContext;

    public a(@NonNull final AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.bX = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.e.b.a.3
            @Override // com.kwad.sdk.core.h.b
            public final void aR() {
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.b
            public final void aS() {
                a.this.pause();
            }
        };
        this.dv = new h.a() { // from class: com.kwad.components.ad.e.b.a.4
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                a.a(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
            }
        };
        this.aM = bVar;
        this.mAdInfo = d.bQ(this.mAdTemplate);
        this.km = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.cN = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            }
        }
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.b.a.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayError(int i, int i2) {
                super.onVideoPlayError(i, i2);
                com.kwad.components.core.j.a.og().b(adTemplate, i, i2);
            }
        };
        this.ko = hVar;
        this.BL.c(hVar);
        aQ();
        this.BL.a(new c.e() { // from class: com.kwad.components.ad.e.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                if (a.this.ew() && a.this.aM.dK()) {
                    a.this.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(a.this.mAdTemplate));
                    a.this.BL.start();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.dt = false;
        return false;
    }

    private void aQ() {
        this.BL.a(new b.a(this.mAdTemplate).bk(d.bS(this.mAdTemplate)).bl(f.b(d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).aJ(this.hasNoCache).b(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate)).rC(), true, true, this.mDetailVideoView);
        setAudioEnabled(h(this.km));
        if (ew()) {
            this.BL.prepareAsync();
            com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ew() {
        if (this.kn) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ae.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ae.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ae.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ae.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.a.a.bi(this.mAdInfo) && ae.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bj(this.mAdInfo) && ae.isWifiConnected(this.mContext);
    }

    private boolean h(boolean z) {
        if (z) {
            if (!com.kwad.sdk.core.config.d.fY()) {
                return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
            }
            if (!this.dt) {
                this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
            }
            return this.dt;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        com.kwad.components.core.video.b bVar = this.BL;
        float f = z ? 1.0f : 0.0f;
        bVar.setVolume(f, f);
    }

    @MainThread
    public final void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.c(gVar);
    }

    public final void aO() {
        k.cj(this.mAdTemplate);
        if (this.BL.oT() == null) {
            aQ();
        }
        if (ew() && this.aM.dK()) {
            this.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
            this.BL.start();
        }
        this.aM.a(this.bX);
    }

    public final void aP() {
        k.ch(this.mAdTemplate);
        this.aM.b(this.bX);
        this.BL.release();
        com.kwad.components.core.m.b.at(this.mContext).b(this.dv);
    }

    @MainThread
    public final void b(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BL.d(gVar);
    }

    public final void ex() {
        this.kn = true;
        if (this.aM.dK()) {
            k.ci(this.mAdTemplate);
            this.BL.a(com.kwad.sdk.contentalliance.kwai.kwai.a.al(this.mAdTemplate));
            this.BL.start();
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
    }

    public final void resume() {
        setAudioEnabled(h(this.km));
        if (ew()) {
            this.BL.resume();
        }
    }
}
