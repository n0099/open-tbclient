package com.kwad.sdk.core.b.a;

import com.kwad.sdk.ranger.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hu implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.aLC = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                dVar.aLC.add((String) optJSONArray.opt(i));
            }
        }
        dVar.aLD = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                d.a aVar = new d.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i2));
                dVar.aLD.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.aLE = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                com.kwad.sdk.ranger.a.a aVar2 = new com.kwad.sdk.ranger.a.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i3));
                dVar.aLE.add(aVar2);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = dVar.funcSwitch;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", j);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "urlList", dVar.aLC);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actConfigList", dVar.aLD);
        long j2 = dVar.byteCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "byteCount", j2);
        }
        double d = dVar.sampleRate;
        if (d != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sampleRate", d);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "anchorNodeList", dVar.aLE);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
