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
    public AdResultData f33917a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f33918b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AdTemplate f33919c;

    public a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.f33917a = adResultData;
        this.f33918b = ksScene;
        this.f33919c = adResultData.adTemplateList.get(0);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(com.kwad.sdk.core.response.b.c.g(this.f33919c));
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        KsSplashScreenFragment a2 = KsSplashScreenFragment.a(this.f33918b, this.f33917a);
        a2.a(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        b a2 = b.a(context, this.f33918b, this.f33917a);
        a2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        return SplashPreloadManager.b().a(this.f33917a) || SplashPreloadManager.b().b(this.f33917a);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.g(this.f33917a.adTemplateList.get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33919c;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }
}
