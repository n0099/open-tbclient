package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class dg implements com.kwad.sdk.core.d<a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.sdkVersion = jSONObject.optString("run_sdk_version");
        if (JSONObject.NULL.toString().equals(bVar.sdkVersion)) {
            bVar.sdkVersion = "";
        }
        bVar.aHQ = jSONObject.optLong("trigger_count", new Long("0").longValue());
        bVar.aHR = jSONObject.optLong("fail_count", new Long("0").longValue());
        bVar.aHS = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        bVar.aHT = jSONObject.optString("business");
        if (JSONObject.NULL.toString().equals(bVar.aHT)) {
            bVar.aHT = "";
        }
        bVar.stage = jSONObject.optString("stage");
        if (JSONObject.NULL.toString().equals(bVar.stage)) {
            bVar.stage = "";
        }
        bVar.aHU = jSONObject.optString("function");
        if (JSONObject.NULL.toString().equals(bVar.aHU)) {
            bVar.aHU = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "run_sdk_version", bVar.sdkVersion);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trigger_count", bVar.aHQ);
        com.kwad.sdk.utils.t.putValue(jSONObject, "fail_count", bVar.aHR);
        com.kwad.sdk.utils.t.putValue(jSONObject, "real_fail_count", bVar.aHS);
        String str2 = bVar.aHT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "business", bVar.aHT);
        }
        String str3 = bVar.stage;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stage", bVar.stage);
        }
        String str4 = bVar.aHU;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "function", bVar.aHU);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
