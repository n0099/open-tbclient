package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.a.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class aw implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aLV = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(aVar.aLV)) {
            aVar.aLV = "";
        }
        aVar.aLW = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(aVar.aLW)) {
            aVar.aLW = "";
        }
        aVar.aLX = jSONObject.optBoolean("childFieldIsStatic");
        aVar.aLY = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(aVar.aLY)) {
            aVar.aLY = "";
        }
        a.b bVar = new a.b();
        aVar.aLZ = bVar;
        bVar.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.ranger.a.a aVar2 = new com.kwad.sdk.ranger.a.a();
        aVar.aMa = aVar2;
        aVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aLV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nodeClassName", aVar.aLV);
        }
        String str2 = aVar.aLW;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldName", aVar.aLW);
        }
        boolean z = aVar.aLX;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = aVar.aLY;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportKey", aVar.aLY);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "childMethod", aVar.aLZ);
        com.kwad.sdk.utils.t.a(jSONObject, "deepNode", aVar.aMa);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
