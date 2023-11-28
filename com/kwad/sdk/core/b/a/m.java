package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class m implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.e.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.anV = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.anV)) {
            bVar.anV = "";
        }
        bVar.anW = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.anX = jSONObject.optBoolean("is_api_native");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.anV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "method_name", bVar.anV);
        }
        boolean z = bVar.anW;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_convert", z);
        }
        int i = bVar.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i);
        }
        boolean z2 = bVar.anX;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_api_native", z2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.e.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
