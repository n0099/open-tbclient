package com.kwad.components.ad.fullscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
/* loaded from: classes10.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.d {
    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.d.class;
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public final int priority() {
        com.kwad.sdk.components.a f = com.kwad.sdk.components.c.f(com.kwad.components.ad.b.g.class);
        if (f == null) {
            return 1;
        }
        return f.priority() + 1;
    }

    @Override // com.kwad.components.ad.b.d
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        f.a(ksScene, new e(ksScene.getPosId(), fullScreenVideoAdListener));
    }
}
