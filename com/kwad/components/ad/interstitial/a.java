package com.kwad.components.ad.interstitial;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes9.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.e {
    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.e.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.e
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        e.loadInterstitialAd(ksScene, interstitialAdListener);
    }
}
