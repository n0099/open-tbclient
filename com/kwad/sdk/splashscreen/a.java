package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a extends AbstrackKsSplashScreenAd {

    /* renamed from: a  reason: collision with root package name */
    public AdResultData f33988a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f33989b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdTemplate f33990c;

    public a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.f33988a = adResultData;
        this.f33989b = ksScene;
        this.f33990c = adResultData.adTemplateList.get(0);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(com.kwad.sdk.core.response.b.c.g(this.f33990c));
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        KsSplashScreenFragment a2 = KsSplashScreenFragment.a(this.f33989b, this.f33988a);
        a2.a(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        b a2 = b.a(context, this.f33989b, this.f33988a);
        a2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        return SplashPreloadManager.b().a(this.f33988a) || SplashPreloadManager.b().b(this.f33988a);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.g(this.f33988a.adTemplateList.get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33990c;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }
}
