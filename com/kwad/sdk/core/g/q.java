package com.kwad.sdk.core.g;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class q extends com.kwad.sdk.core.network.d {
    public q(com.kwad.sdk.core.g.a.f fVar, long j) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_AUTHOR_ID, j);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.k();
    }
}
