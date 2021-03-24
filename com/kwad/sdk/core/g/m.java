package com.kwad.sdk.core.g;

import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class m extends com.kwad.sdk.core.network.d {
    public m(h.a aVar, long j) {
        JSONArray jSONArray = new JSONArray();
        for (com.kwad.sdk.core.g.a.f fVar : aVar.f33784a) {
            com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        }
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f33785b);
        a(URLPackage.KEY_TREND_ID, j);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.i();
    }
}
