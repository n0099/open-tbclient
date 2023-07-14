package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public final class j extends com.kwad.sdk.core.network.d {
    public j(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.a.a.be(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.r.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.qQ();
    }
}
