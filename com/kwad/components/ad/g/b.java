package com.kwad.components.ad.g;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes9.dex */
public class b implements i.a {
    public static volatile b BK;

    public static b kO() {
        if (BK == null) {
            synchronized (b.class) {
                if (BK == null) {
                    BK = new b();
                }
            }
        }
        return BK;
    }

    @Override // com.kwad.sdk.core.network.i.a
    public final void a(g gVar, int i) {
        if ((gVar instanceof com.kwad.components.core.k.a) && i != f.Yd.errorCode) {
            int i2 = 21004;
            SceneImpl scene = gVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i == f.XY.errorCode) {
                    i2 = 21001;
                } else if (i == f.Yc.errorCode) {
                    i2 = 21003;
                } else if (i > 0 && i < 1000) {
                    i2 = 21002;
                }
                com.kwad.components.core.j.a.og().a(posId, i2);
            }
        }
    }

    public final void init() {
        i.tB().a(this);
    }
}
