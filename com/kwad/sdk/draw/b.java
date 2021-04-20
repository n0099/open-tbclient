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
/* loaded from: classes6.dex */
public class b extends AbstractKsDrawAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34819a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f34820b;

    /* renamed from: c  reason: collision with root package name */
    public a f34821c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f34819a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.U(c.j(adTemplate)).a(), this.f34819a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        if (this.f34821c == null) {
            a aVar = new a(context);
            this.f34821c = aVar;
            aVar.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.sdk.draw.b.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdClicked() {
                    if (b.this.f34820b != null) {
                        b.this.f34820b.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdShow() {
                    if (b.this.f34820b != null) {
                        b.this.f34820b.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    if (b.this.f34820b != null) {
                        try {
                            b.this.f34820b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayError() {
                    if (b.this.f34820b != null) {
                        try {
                            b.this.f34820b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayPause() {
                    if (b.this.f34820b != null) {
                        try {
                            b.this.f34820b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayResume() {
                    if (b.this.f34820b != null) {
                        try {
                            b.this.f34820b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayStart() {
                    if (b.this.f34820b != null) {
                        try {
                            b.this.f34820b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            });
            this.f34821c.a(this.f34819a);
        } else {
            com.kwad.sdk.core.d.a.b("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.f34821c;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(c.j(this.f34819a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f34820b = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f34819a;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }
}
