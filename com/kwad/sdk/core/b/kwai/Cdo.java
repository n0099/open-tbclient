package com.kwad.sdk.core.b.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kwad.sdk.core.b.kwai.do  reason: invalid class name */
/* loaded from: classes5.dex */
public final class Cdo implements com.kwad.sdk.core.d<com.kwad.sdk.e.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optString("sceneId");
        if (jSONObject.opt("sceneId") == JSONObject.NULL) {
            aVar.a = "";
        }
        aVar.b = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.kwad.sdk.e.kwai.b bVar = new com.kwad.sdk.e.kwai.b();
                bVar.parseJson(optJSONArray.optJSONObject(i));
                aVar.b.add(bVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "sceneId", aVar.a);
        com.kwad.sdk.utils.r.a(jSONObject, "packages", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.e.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
