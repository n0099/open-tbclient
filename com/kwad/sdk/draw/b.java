package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class b extends AbstractKsDrawAd {
    @NonNull
    public AdTemplate a;
    @Nullable
    public KsDrawAd.AdInteractionListener b;
    public a c;

    public b(@NonNull AdTemplate adTemplate) {
        this.a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.aa(d.j(adTemplate)).a(), this.a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        if (this.c == null) {
            a aVar = new a(context);
            this.c = aVar;
            aVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.sdk.draw.b.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdClicked() {
                    if (b.this.b != null) {
                        b.this.b.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdShow() {
                    if (b.this.b != null) {
                        b.this.b.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    if (b.this.b != null) {
                        try {
                            b.this.b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayError() {
                    if (b.this.b != null) {
                        try {
                            b.this.b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayPause() {
                    if (b.this.b != null) {
                        try {
                            b.this.b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayResume() {
                    if (b.this.b != null) {
                        try {
                            b.this.b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayStart() {
                    if (b.this.b != null) {
                        try {
                            b.this.b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            });
            this.c.a(this.a);
        } else {
            com.kwad.sdk.core.d.a.c("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(d.j(this.a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(d.j(this.a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(d.j(this.a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.a, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.b = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.a;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }
}
