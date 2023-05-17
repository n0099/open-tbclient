package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    public b aT;
    @NonNull
    public AdTemplate mAdTemplate;

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.bQ(adTemplate)).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (this.aT == null) {
            b bVar = new b(context);
            this.aT = bVar;
            bVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onAdClicked() {
                    if (c.this.aJ != null) {
                        c.this.aJ.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onAdShow() {
                    if (c.this.aJ != null) {
                        c.this.aJ.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayEnd() {
                    if (c.this.aJ != null) {
                        try {
                            c.this.aJ.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayError() {
                    if (c.this.aJ != null) {
                        try {
                            c.this.aJ.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayPause() {
                    if (c.this.aJ != null) {
                        try {
                            c.this.aJ.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayResume() {
                    if (c.this.aJ != null) {
                        try {
                            c.this.aJ.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public final void onVideoPlayStart() {
                    if (c.this.aJ != null) {
                        try {
                            c.this.aJ.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                }
            });
            this.aT.b(this.mAdTemplate);
        } else {
            com.kwad.sdk.core.e.b.i("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.aT;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.ap(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aD(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.aJ = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.aA(adTemplate);
    }
}
