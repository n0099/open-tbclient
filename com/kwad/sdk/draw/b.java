package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class b extends AbstractKsDrawAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35279a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f35280b;

    /* renamed from: c  reason: collision with root package name */
    public a f35281c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f35279a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.U(c.j(adTemplate)).a(), this.f35279a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        if (this.f35281c == null) {
            a aVar = new a(context);
            this.f35281c = aVar;
            aVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.sdk.draw.b.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdClicked() {
                    if (b.this.f35280b != null) {
                        b.this.f35280b.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdShow() {
                    if (b.this.f35280b != null) {
                        b.this.f35280b.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    if (b.this.f35280b != null) {
                        try {
                            b.this.f35280b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayError() {
                    if (b.this.f35280b != null) {
                        try {
                            b.this.f35280b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayPause() {
                    if (b.this.f35280b != null) {
                        try {
                            b.this.f35280b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayResume() {
                    if (b.this.f35280b != null) {
                        try {
                            b.this.f35280b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayStart() {
                    if (b.this.f35280b != null) {
                        try {
                            b.this.f35280b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            });
            this.f35281c.a(this.f35279a);
        } else {
            com.kwad.sdk.core.d.a.b("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.f35281c;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(c.j(this.f35279a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f35280b = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f35279a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }
}
