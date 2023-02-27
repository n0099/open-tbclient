package com.kwad.components.core.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static volatile c IR;

    @NonNull
    public static c ox() {
        if (IR == null) {
            synchronized (c.class) {
                if (IR == null) {
                    IR = new c();
                }
            }
        }
        return IR;
    }

    public final void a(final AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.report.f fVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.e.b.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        com.kwad.sdk.core.report.a.b(adTemplate, (JSONObject) null, fVar);
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.m.c.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.a.a lP = com.kwad.components.core.a.a.lP();
                if (lP != null) {
                    lP.j(com.kwad.sdk.core.response.a.d.ca(adTemplate));
                }
            }
        });
        com.kwad.components.core.a.f.mb().I(adTemplate);
    }
}
