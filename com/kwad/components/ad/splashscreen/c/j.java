package com.kwad.components.ad.splashscreen.c;

import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class j extends e {
    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.j.1
            @Override // java.lang.Runnable
            public final void run() {
                j.this.bQ();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.obfuscated_res_0x7f092361).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bc(dP)) {
            a(new d(), true);
            a(new q(), true);
        } else {
            a(new h(), true);
        }
        if (this.Df.Cx) {
            a(new p(), true);
        } else {
            boolean dr = com.kwad.sdk.core.response.b.b.dr(dP);
            boolean dv = com.kwad.sdk.core.response.b.b.dv(dP);
            boolean dA = com.kwad.sdk.core.response.b.b.dA(dP);
            if (com.kwad.sdk.core.response.b.b.dx(dP)) {
                a(new n(), true);
            } else if (dr) {
                a(new m(), true);
            } else if (dv) {
                a(new l(), true);
            } else if (dA) {
                a(new p(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aP(dP)) {
            a(new f(), true);
        }
        a(new com.kwad.components.ad.splashscreen.c.b.b(), true);
        a(new a(), true);
        a(new g(), true);
    }
}
