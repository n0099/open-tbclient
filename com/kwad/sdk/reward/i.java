package com.kwad.sdk.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class i extends com.kwad.sdk.core.network.d {
    public i(AdTemplate adTemplate) {
        b("callbackUrlInfo", com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.j(adTemplate)));
        com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.a(jSONArray, fVar.toJson());
        a("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.f();
    }
}
