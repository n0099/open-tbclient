package com.kwad.components.ad.draw;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes9.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.b {
    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.b.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.b
    public final void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        d.loadDrawAd(ksScene, drawAdListener);
    }
}
