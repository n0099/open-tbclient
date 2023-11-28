package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gx implements com.kwad.sdk.core.d<com.kwad.components.core.n.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.components.core.n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Mr = jSONObject.optInt("load_module");
        bVar.Ms = jSONObject.optLong("load_status");
        bVar.Mt = jSONObject.optLong("load_duration_ms");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.components.core.n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.Mr;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_module", i);
        }
        long j = bVar.Ms;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", j);
        }
        long j2 = bVar.Mt;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_duration_ms", j2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
