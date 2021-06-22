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
/* loaded from: classes7.dex */
public class a extends AbstrackKsSplashScreenAd {

    /* renamed from: a  reason: collision with root package name */
    public AdResultData f37447a;

    /* renamed from: b  reason: collision with root package name */
    public KsScene f37448b;

    public a(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.f37447a = adResultData;
        this.f37448b = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        KsSplashScreenFragment a2 = KsSplashScreenFragment.a(this.f37448b, this.f37447a);
        a2.a(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @NonNull
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        b a2 = b.a(context, this.f37448b, this.f37447a);
        a2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return a2;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        return SplashPreloadManager.b().a(this.f37447a) || SplashPreloadManager.b().b(this.f37447a);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.c.j(this.f37447a.adTemplateList.get(0)));
    }
}
