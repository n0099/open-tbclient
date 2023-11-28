package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fv implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aQF = jSONObject.optInt("put_count");
        aVar.aQG = jSONObject.optInt("get_failed_count");
        aVar.aQH = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.aQF;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "put_count", i);
        }
        int i2 = aVar.aQG;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_failed_count", i2);
        }
        int i3 = aVar.aQH;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "get_success_count", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
