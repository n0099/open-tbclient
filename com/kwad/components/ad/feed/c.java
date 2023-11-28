package com.kwad.components.ad.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.b.m;
import com.kwad.components.ad.feed.b.n;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class c extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    public KsFeedAd.AdInteractionListener dQ;
    public com.kwad.components.core.widget.b dR;
    public n dS;
    public boolean dT;
    public final KsAdVideoPlayConfig dU;
    public final AdInfo mAdInfo;
    @NonNull
    public final AdResultData mAdResultData;
    @NonNull
    public final AdTemplate mAdTemplate;
    public AtomicBoolean dV = new AtomicBoolean(false);
    public AtomicBoolean dW = new AtomicBoolean(false);
    public AtomicInteger dX = new AtomicInteger(2);
    public com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public com.kwad.sdk.core.h.b bT = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.feed.c.1
        @Override // com.kwad.sdk.core.h.b
        public final void ah() {
            c.this.bZ.h(c.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void ai() {
            c.this.bZ.i(c.this);
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void c(int i, String str);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    public c(@NonNull AdResultData adResultData, boolean z) {
        this.mAdResultData = adResultData;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        this.mAdTemplate = m;
        m.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(m);
        this.dT = z;
        this.dU = new KSAdVideoPlayConfigImpl();
        com.kwad.components.ad.h.b.eH().a(this);
    }

    @Nullable
    private com.kwad.components.core.widget.b<?, ?> C(Context context) {
        com.kwad.components.core.widget.b<?, ?> a2;
        int width = this.mAdTemplate.mAdScene.getWidth();
        if (width < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqK) * k.getScreenWidth(context)) {
            com.kwad.components.ad.feed.monitor.b.a(width, com.kwad.sdk.core.response.b.a.be(this.mAdInfo), this.mAdTemplate.type);
        }
        if (com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate)) {
            n nVar = new n(l.wrapContextIfNeed(context));
            this.dS = nVar;
            nVar.setWidth(width);
            this.dS.setVideoPlayConfig(this.dU);
            a2 = this.dS;
        } else if (this.dT && com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate)) {
            try {
                context = l.wrapContextIfNeed(context);
                m mVar = new m(context);
                mVar.setWidth(width);
                mVar.setVideoPlayConfig(this.dU);
                a2 = mVar;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                a2 = null;
            }
        } else {
            a2 = b.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
        }
        if (a2 != null) {
            if (!(a2 instanceof n)) {
                a2.setMargin(com.kwad.sdk.d.a.a.a(context, 16.0f));
            }
            a2.setPageExitListener(this.bT);
        }
        return a2;
    }

    public final void a(@NonNull final a aVar) {
        com.kwad.sdk.i.a.f("feed", "show", "feed_preload_view");
        Context context = ServiceProvider.getContext();
        this.mAdTemplate.loadType = 2;
        this.dV.set(true);
        com.kwad.components.core.widget.b<?, ?> C = C(context);
        this.dR = C;
        if (C != null) {
            if (C instanceof m) {
                m mVar = (m) C;
                mVar.setPreloadListener(new m.a() { // from class: com.kwad.components.ad.feed.c.4
                    @Override // com.kwad.components.ad.feed.b.m.a
                    public final void c(int i, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.dR, false);
                        c.this.dW.set(true);
                        aVar.c(i, str);
                    }
                });
                mVar.b(this.mAdResultData);
            } else if (C instanceof n) {
                n nVar = (n) C;
                nVar.setTKLoadListener(new n.a() { // from class: com.kwad.components.ad.feed.c.5
                    @Override // com.kwad.components.ad.feed.b.n.a
                    public final void c(int i, String str) {
                        c cVar = c.this;
                        cVar.a(cVar.dR, false);
                        c.this.dW.set(true);
                        aVar.c(i, str);
                    }
                });
                nVar.b(this.mAdResultData);
            } else {
                C.b((com.kwad.components.core.widget.b<?, ?>) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.dR;
                if (bVar instanceof com.kwad.components.ad.feed.b.c) {
                    ((com.kwad.components.ad.feed.b.c) bVar).a(this.dU);
                }
                a(this.dR, true);
                this.dW.set(true);
                aVar.c(1, "");
            }
        } else {
            this.dW.set(false);
            this.dV.set(false);
            aVar.c(1, "render Failed");
        }
        com.kwad.sdk.i.a.g("feed", "show", "feed_preload_view");
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            Context wrapContextIfNeed = l.wrapContextIfNeed(context);
            com.kwad.sdk.i.a.ai("feed", "show");
            com.kwad.sdk.commercial.e.c.bz(this.mAdTemplate);
            if (this.dR != null) {
                if (this.dR.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.dR.getParent()).removeView(this.dR);
                }
                com.kwad.sdk.i.a.aj("feed", "show");
                return this.dR;
            }
            aS();
            this.mAdTemplate.loadType = 1;
            com.kwad.components.core.widget.b<?, ?> C = C(wrapContextIfNeed);
            this.dR = C;
            if (C == null) {
                com.kwad.sdk.i.a.aj("feed", "show");
                return null;
            }
            C.b((com.kwad.components.core.widget.b<?, ?>) this.mAdResultData);
            if (this.dR instanceof com.kwad.components.ad.feed.b.c) {
                ((com.kwad.components.ad.feed.b.c) this.dR).a(this.dU);
            }
            if (this.dR instanceof m) {
                a(this.dR, false);
            } else {
                a(this.dR, true);
            }
            com.kwad.sdk.i.a.aj("feed", "show");
            return this.dR;
        } catch (Throwable th) {
            if (KsAdSDKImpl.get().getIsExternal()) {
                com.kwad.components.core.d.a.b(th);
                return null;
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    @SuppressLint({"WrongConstant"})
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.dU.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                this.dU.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
            } else if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                this.dU.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
            } else {
                this.dU.setDataFlowAutoStart(com.kwad.sdk.core.config.d.AU());
                try {
                    this.dU.setVideoAutoPlayType(0);
                } catch (NoSuchMethodError unused) {
                } catch (Throwable th) {
                    com.kwad.components.core.d.a.b(th);
                }
            }
            com.kwad.components.core.widget.b bVar = this.dR;
            if (bVar instanceof m) {
                ((m) bVar).setVideoPlayConfig(this.dU);
            }
            com.kwad.components.core.widget.b bVar2 = this.dR;
            if (bVar2 instanceof n) {
                ((n) bVar2).setVideoPlayConfig(this.dU);
            }
            com.kwad.components.core.widget.b bVar3 = this.dR;
            if (bVar3 instanceof com.kwad.components.ad.feed.b.c) {
                ((com.kwad.components.ad.feed.b.c) bVar3).setVideoPlayConfig(this.dU);
            }
        }
        if (isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        this.dQ = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        this.dU.setVideoSoundEnable(z);
        if (this.dU.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.widget.b bVar, final boolean z) {
        if (bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.a() { // from class: com.kwad.components.ad.feed.c.6
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                int i;
                if (c.this.dQ != null) {
                    c.this.dQ.onAdClicked();
                }
                AdTemplate adTemplate = c.this.mAdTemplate;
                String bb = com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo);
                if (z) {
                    i = 1;
                } else {
                    i = 2;
                }
                com.kwad.components.ad.feed.monitor.b.a(4, adTemplate, bb, i);
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (c.this.dQ != null) {
                    try {
                        c.this.dQ.onDownloadTipsDialogDismiss();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (c.this.dQ != null) {
                    try {
                        c.this.dQ.onDownloadTipsDialogShow();
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                int i;
                com.kwad.components.ad.feed.monitor.b.f(c.this.mAdTemplate);
                com.kwad.sdk.commercial.e.c.bA(c.this.mAdTemplate);
                if (c.this.dQ != null) {
                    c.this.dQ.onAdShow();
                }
                AdTemplate adTemplate = c.this.mAdTemplate;
                String bb = com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo);
                if (z) {
                    i = 1;
                } else {
                    i = 2;
                }
                com.kwad.components.ad.feed.monitor.b.a(3, adTemplate, bb, i);
                if (z) {
                    j jVar = new j();
                    y.a aVar = new y.a();
                    FeedType fromInt = FeedType.fromInt(c.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    jVar.a(aVar);
                    jVar.x(c.this.dR.getHeight(), c.this.dR.getWidth());
                    com.kwad.components.core.s.b.qL().a(c.this.mAdTemplate, null, jVar);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                int i;
                if (c.this.dQ != null) {
                    c.this.dQ.onDislikeClicked();
                    try {
                        if (bVar.getParent() instanceof ViewGroup) {
                            ((ViewGroup) bVar.getParent()).removeView(bVar);
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
                AdTemplate adTemplate = c.this.mAdTemplate;
                String bb = com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo);
                if (z) {
                    i = 1;
                } else {
                    i = 2;
                }
                com.kwad.components.ad.feed.monitor.b.a(5, adTemplate, bb, i);
            }
        });
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.k(adTemplate, j2);
    }

    private void aS() {
        if (this.mAdTemplate != null) {
            com.kwad.sdk.core.diskcache.b.a BS = com.kwad.sdk.core.diskcache.b.a.BS();
            BS.remove("feed_ad_cache_" + this.mAdTemplate.posId);
        }
    }

    private boolean isVideoSoundEnable() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            }
        }
        return com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.AO()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void render(final KsFeedAd.AdRenderListener adRenderListener) {
        final int i;
        if (this.dW.get()) {
            if (this.dR == null) {
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atx;
                adRenderListener.onAdRenderFailed(eVar.errorCode, eVar.msg);
                this.dW.set(false);
                this.dV.set(false);
                return;
            }
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    adRenderListener.onAdRenderSuccess(c.this.dR);
                    com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.dX.get());
                }
            });
        } else if (this.dV.get()) {
        } else {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.feed.monitor.b.e(this.mAdTemplate);
            if (com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate)) {
                i = 3;
            } else {
                i = 2;
            }
            this.dV.set(true);
            a(new a() { // from class: com.kwad.components.ad.feed.c.3
                @Override // com.kwad.components.ad.feed.c.a
                public final void c(int i2, String str) {
                    com.kwad.components.ad.feed.monitor.b.a(c.this.getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                    c.this.dX.set(i2);
                    c.this.dW.set(true);
                    try {
                        if (adRenderListener != null) {
                            if (c.this.dR == null) {
                                adRenderListener.onAdRenderFailed(com.kwad.sdk.core.network.e.atx.errorCode, com.kwad.sdk.core.network.e.atx.msg);
                            } else {
                                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.c.3.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        adRenderListener.onAdRenderSuccess(c.this.dR);
                                        com.kwad.components.ad.feed.monitor.b.a(2, c.this.mAdTemplate, com.kwad.sdk.core.response.b.a.bb(c.this.mAdInfo), c.this.dX.get());
                                    }
                                });
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
