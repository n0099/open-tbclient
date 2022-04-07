package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes5.dex */
public abstract class AbstrackKsSplashScreenAd implements KsSplashScreenAd {
    @Override // com.kwad.sdk.api.KsSplashScreenAd
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Fragment getFragment(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return getFragment2(splashScreenAdInteractionListener).getBase();
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public abstract KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    @NonNull
    @KsAdSdkDynamicApi
    public View getView(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return getView2(Wrapper.wrapContextIfNeed(context), splashScreenAdInteractionListener);
    }

    @NonNull
    @KsAdSdkDynamicApi
    public abstract View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener);
}
