package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @Override // com.kwad.sdk.api.KsFeedAd
    @KsAdSdkDynamicApi
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    public abstract View getFeedView2(Context context);
}
