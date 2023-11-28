package com.kwad.components.ad.i;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes10.dex */
public class b implements h.a {
    public static volatile b Hq;

    public static b lW() {
        if (Hq == null) {
            synchronized (b.class) {
                if (Hq == null) {
                    Hq = new b();
                }
            }
        }
        return Hq;
    }

    public final void init() {
        h.CC().a(this);
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        if (!(fVar instanceof com.kwad.components.core.request.a) || i == e.ats.errorCode) {
            return;
        }
        int i2 = 21004;
        SceneImpl scene = fVar.getScene();
        if (scene != null) {
            long posId = scene.getPosId();
            if (i == e.atn.errorCode) {
                i2 = 21001;
            } else if (i == e.atr.errorCode) {
                i2 = 21003;
            } else if (i > 0 && i < 1000) {
                i2 = 21002;
            }
            com.kwad.components.core.o.a.pX().a(posId, i2);
        }
    }
}
