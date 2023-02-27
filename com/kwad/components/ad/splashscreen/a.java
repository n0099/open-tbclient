package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.h {
    public c xj;

    @Override // com.kwad.components.ad.a.h
    public final void a(Context context, String str, boolean z, Rect rect) {
        c cVar = new c(context, str, false, null);
        this.xj = cVar;
        cVar.a(rect);
    }

    @Override // com.kwad.components.ad.a.h
    public final void ag() {
        c cVar = this.xj;
        if (cVar != null) {
            cVar.jo();
            this.xj = null;
        }
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        return com.kwad.components.ad.a.h.class;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
    }

    @Override // com.kwad.components.ad.a.h
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        b.loadSplashScreenAd(ksScene, splashScreenAdListener);
    }
}
