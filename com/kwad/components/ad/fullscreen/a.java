package com.kwad.components.ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.a.g;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes9.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.d {
    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.d.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.d
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        c.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener);
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        com.kwad.sdk.components.a f = com.kwad.sdk.components.c.f(g.class);
        if (f != null) {
            return f.priority() + 1;
        }
        return 1;
    }
}
