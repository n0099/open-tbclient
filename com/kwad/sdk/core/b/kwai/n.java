package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class n implements com.kwad.sdk.core.d {
    public static void a(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ED = jSONObject.optInt("currentActiveCount");
        aVar.EE = jSONObject.optLong("lastForceActiveTimestamp");
    }

    public static JSONObject b(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.ED;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentActiveCount", i);
        }
        long j = aVar.EE;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "lastForceActiveTimestamp", j);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.f.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.f.a) bVar, jSONObject);
    }
}
