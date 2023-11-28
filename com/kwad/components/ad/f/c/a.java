package com.kwad.components.ad.f.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class a extends b {
    public com.kwad.components.core.widget.a.b bQ;
    public KsAdVideoPlayConfig dU;
    public final c df;
    public boolean eQ;
    public a.b eY;
    public OfflineOnAudioConflictListener fa;
    public boolean hasNoCache;
    public final AdInfo mAdInfo;
    public Context mContext;
    public boolean nn;
    public boolean no;
    public l np;

    public a(@NonNull final AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.df = new c() { // from class: com.kwad.components.ad.f.c.a.3
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                com.kwad.components.core.j.a.ow().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                com.kwad.components.core.j.a.ow().c(a.this.eY);
                a.this.pause();
            }
        };
        this.fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.c.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }
        };
        this.bQ = bVar;
        this.mAdInfo = e.dP(this.mAdTemplate);
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.nn = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.nn = com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
        }
        this.dU = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.c.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.o.a.pX().c(adTemplate, i, i2);
            }
        };
        this.np = lVar;
        this.Hr.c(lVar);
        aL();
        this.Hr.a(new c.e() { // from class: com.kwad.components.ad.f.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                if (a.this.eB() && a.this.bQ.dW()) {
                    a.this.Hr.a(com.kwad.sdk.contentalliance.a.a.a.bE(a.this.mAdTemplate));
                    com.kwad.components.core.j.a.ow().a(a.this.getCurrentVoiceItem());
                    a.this.Hr.start();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.Hr.setAudioEnabled(z);
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.eQ = false;
        return false;
    }

    private void aL() {
        this.Hr.a(new b.a(this.mAdTemplate).cD(e.dR(this.mAdTemplate)).cE(h.b(e.dQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bl(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate)).Ah(), true, true, this.mDetailVideoView);
        setAudioEnabled(g(this.nn));
        if (!eB()) {
            return;
        }
        this.Hr.prepareAsync();
        com.kwad.components.core.s.a.ah(this.mContext).a(this.fa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eB() {
        if (this.no) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (ag.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ag.isMobileConnected(this.mContext))) {
                    return true;
                }
                return false;
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(this.mAdInfo) && ag.isNetworkConnected(this.mContext)) {
            return true;
        }
        if (com.kwad.sdk.core.response.b.a.bV(this.mAdInfo) && ag.isWifiConnected(this.mContext)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z) {
        if (!z) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.ow();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
        }
        if (!d.gq()) {
            if (!com.kwad.components.core.s.a.ah(this.mContext).qK()) {
                return com.kwad.components.core.s.a.ah(this.mContext).aM(false);
            }
            if (com.kwad.components.core.s.a.ah(this.mContext).qJ()) {
                return false;
            }
            return true;
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.ah(this.mContext).aM(true);
        }
        return this.eQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.f.c.a.4
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.g(aVar.nn));
                }
            });
        }
        return this.eY;
    }

    public final void aK() {
        com.kwad.sdk.utils.l.ei(this.mAdTemplate);
        this.bQ.b(this.df);
        this.Hr.release();
        com.kwad.components.core.j.a.ow().c(this.eY);
        com.kwad.components.core.s.a.ah(this.mContext).b(this.fa);
    }

    public final void eC() {
        this.no = true;
        if (this.bQ.dW()) {
            com.kwad.sdk.utils.l.ej(this.mAdTemplate);
            this.Hr.a(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate));
            com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
            this.Hr.start();
        }
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
        setAudioEnabled(g(this.nn));
        if (!eB()) {
            return;
        }
        super.resume();
    }

    public final void aJ() {
        com.kwad.sdk.utils.l.ek(this.mAdTemplate);
        if (this.Hr.rf() == null) {
            aL();
        }
        if (eB() && this.bQ.dW()) {
            this.Hr.a(com.kwad.sdk.contentalliance.a.a.a.bE(this.mAdTemplate));
            com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
            this.Hr.start();
        }
        this.bQ.a(this.df);
    }
}
