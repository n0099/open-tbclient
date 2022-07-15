package com.kwad.sdk.core.report;

import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public d(List<m> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (m mVar : list) {
            com.kwad.sdk.utils.r.a(jSONArray, mVar.a());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.f();
    }
}
