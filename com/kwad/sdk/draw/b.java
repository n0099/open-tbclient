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
/* loaded from: classes4.dex */
public class b extends AbstractKsDrawAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f9676a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private KsDrawAd.AdInteractionListener f9677b;
    private a c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f9676a = adTemplate;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.U(c.j(this.f9676a)).a(), this.f9676a);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public View getDrawView2(Context context) {
        if (this.c == null) {
            this.c = new a(context);
            this.c.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.kwad.sdk.draw.b.1
                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdClicked() {
                    if (b.this.f9677b != null) {
                        b.this.f9677b.onAdClicked();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onAdShow() {
                    if (b.this.f9677b != null) {
                        b.this.f9677b.onAdShow();
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    if (b.this.f9677b != null) {
                        try {
                            b.this.f9677b.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayError() {
                    if (b.this.f9677b != null) {
                        try {
                            b.this.f9677b.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayPause() {
                    if (b.this.f9677b != null) {
                        try {
                            b.this.f9677b.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayResume() {
                    if (b.this.f9677b != null) {
                        try {
                            b.this.f9677b.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }

                @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
                public void onVideoPlayStart() {
                    if (b.this.f9677b != null) {
                        try {
                            b.this.f9677b.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            });
            this.c.a(this.f9676a);
        } else {
            com.kwad.sdk.core.d.a.b("KSDrawAdControl", "mDrawVideoView is not null");
        }
        return this.c;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(c.j(this.f9676a));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f9677b = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public void setBidEcpm(int i) {
        this.f9676a.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(this.f9676a);
    }
}
