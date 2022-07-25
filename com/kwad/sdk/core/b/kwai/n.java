package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.components.core.f.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ED = jSONObject.optInt("currentActiveCount");
        aVar.EE = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.f.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
