package com.kwad.components.core.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static volatile b SO;

    @NonNull
    public static b qL() {
        if (SO == null) {
            synchronized (b.class) {
                if (SO == null) {
                    SO = new b();
                }
            }
        }
        return SO;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public final boolean a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.j jVar) {
        boolean z = false;
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.e.c.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        if (jVar != null) {
            jVar.a(adTemplate, null, null, null);
        }
        boolean b = com.kwad.sdk.core.report.a.b(adTemplate, jSONObject, jVar);
        try {
            if (adTemplate.mAdScene != null && adTemplate.mAdScene.adStyle == 10000) {
                z = true;
            }
            if (adTemplate.adStyle == 3 || adTemplate.adStyle == 2 || adTemplate.adStyle == 13 || z) {
                com.kwad.sdk.core.response.b.e.dP(adTemplate);
                if (b && com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                    com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                }
            }
        } catch (Throwable unused) {
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.s.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.c.a mn = com.kwad.components.core.c.a.mn();
                if (mn != null) {
                    mn.r(com.kwad.sdk.core.response.b.e.dZ(adTemplate));
                }
            }
        });
        com.kwad.components.core.c.g.mC().ak(adTemplate);
        return b;
    }
}
