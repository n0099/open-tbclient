package com.kwad.sdk.core.g;

import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class m extends com.kwad.sdk.core.network.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h.a aVar, long j) {
        JSONArray jSONArray = new JSONArray();
        for (com.kwad.sdk.core.g.a.f fVar : aVar.f9263a) {
            com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f9264b);
        a(URLPackage.KEY_TREND_ID, j);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.i();
    }
}
