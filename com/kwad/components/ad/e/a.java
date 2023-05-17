package com.kwad.components.ad.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.a.f;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes9.dex */
public class a extends com.kwad.sdk.components.d implements f {
    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return f.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.f
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        b.loadNativeAd(ksScene, nativeAdListener);
    }

    @Override // com.kwad.components.ad.a.f
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        b.loadNativeAd(str, nativeAdListener);
    }
}
