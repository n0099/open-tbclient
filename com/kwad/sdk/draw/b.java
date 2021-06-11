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
    public AdTemplate f35181a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f35182b;

    /* renamed from: c  reason: collision with root package name */
    public a f35183c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f35181a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.U(c.j(adTemplate)).a(), this.f35181a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        if (this.f35183c == null) {
            a aVar = new a(context);
            this.f35183c = aVar;
            aVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.sdk.draw.b.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdClicked() {
                    if (b.this.f35182b != null) {
                        b.this.f35182b.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdShow() {
                    if (b.this.f35182b != null) {
                        b.this.f35182b.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    if (b.this.f35182b != null) {
                        try {
                            b.this.f35182b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayError() {
                    if (b.this.f35182b != null) {
                        try {
                            b.this.f35182b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayPause() {
                    if (b.this.f35182b != null) {
                        try {
                            b.this.f35182b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayResume() {
                    if (b.this.f35182b != null) {
                        try {
                            b.this.f35182b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayStart() {
                    if (b.this.f35182b != null) {
                        try {
                            b.this.f35182b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            });
            this.f35183c.a(this.f35181a);
        } else {
            com.kwad.sdk.core.d.a.b("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.f35183c;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(c.j(this.f35181a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f35182b = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f35181a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }
}
