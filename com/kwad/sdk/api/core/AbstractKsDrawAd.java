package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    @Override // com.kwad.sdk.api.KsDrawAd
    @KsAdSdkDynamicApi
    public final View getDrawView(Context context) {
        return getDrawView2(Wrapper.wrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    public abstract View getDrawView2(Context context);
}
