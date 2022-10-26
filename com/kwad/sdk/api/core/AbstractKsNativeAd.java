package com.kwad.sdk.api.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public abstract class AbstractKsNativeAd implements KsNativeAd {
    @KsAdSdkDynamicApi
    public abstract Bitmap getSdkLogo();

    @Override // com.kwad.sdk.api.KsNativeAd
    @KsAdSdkDynamicApi
    public final View getVideoView(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), ksAdVideoPlayConfig);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @KsAdSdkDynamicApi
    public final View getVideoView(Context context, boolean z) {
        return getVideoView2(Wrapper.wrapContextIfNeed(context), z);
    }

    @KsAdSdkDynamicApi
    public abstract View getVideoView2(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkDynamicApi
    public abstract View getVideoView2(Context context, boolean z);
}
