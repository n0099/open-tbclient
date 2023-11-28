package com.kwad.components.ad.draw;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {
    @Nullable
    public KsDrawAd.AdInteractionListener bN;
    public b bY;
    @NonNull
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public final com.kwad.sdk.core.h.b bT = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.draw.c.1
        @Override // com.kwad.sdk.core.h.b
        public final void ah() {
            c.this.bZ.h(c.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void ai() {
            c.this.bZ.i(c.this);
        }
    };
    public final KsDrawAd.AdInteractionListener ca = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.bN != null) {
                c.this.bN.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.bN != null) {
                c.this.bN.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.bN != null) {
                try {
                    c.this.bN.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                }
            }
        }
    };

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.br(e.dP(adTemplate)).getUrl(), this.mAdTemplate);
        com.kwad.components.ad.h.b.eH().a(this);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bN = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(e.dP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(e.dP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(e.dP(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.AO()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (context != null && KsAdSDKImpl.get().hasInitFinish()) {
            try {
                context = l.wrapContextIfNeed(context);
                com.kwad.sdk.i.a.ai("draw", "show");
                if (this.bY == null) {
                    b bVar = new b(context);
                    this.bY = bVar;
                    bVar.setPageExitListener(this.bT);
                    this.bY.setAdInteractionListener(this.bN);
                    this.bY.a(this.mAdTemplate);
                } else {
                    com.kwad.sdk.core.e.c.i("KSDrawAdControl", "mDrawVideoView is not null");
                }
                com.kwad.sdk.i.a.aj("draw", "show");
            } catch (Throwable th) {
                if (KsAdSDKImpl.get().getIsExternal()) {
                    RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader());
                    if (Build.VERSION.SDK_INT >= 19) {
                        runtimeException.addSuppressed(th);
                    }
                    com.kwad.components.core.d.a.b(runtimeException);
                } else {
                    throw th;
                }
            }
            return this.bY;
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.k(adTemplate, j2);
    }
}
