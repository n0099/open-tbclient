package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
/* loaded from: classes10.dex */
public class b {
    public double anQ;
    public double anR;
    public String anS = BuildConfig.VERSION_NAME;

    public final void zT() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null) {
            this.anR = hVar.yy();
        }
    }
}
