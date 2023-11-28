package com.kwad.sdk.core.b.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bd implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.commercial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.anF = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.anF)) {
            bVar.anF = "";
        }
        bVar.anM = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.anM)) {
            bVar.anM = "";
        }
        bVar.anN = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.anN)) {
            bVar.anN = "";
        }
        bVar.anO = jSONObject.optInt("store_type");
        bVar.anP = jSONObject.optInt("launch_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.commercial.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.anF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.anF);
        }
        String str3 = bVar.anM;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_path", bVar.anM);
        }
        String str4 = bVar.anN;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "market_pkg_name", bVar.anN);
        }
        int i2 = bVar.anO;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "store_type", i2);
        }
        int i3 = bVar.anP;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "launch_type", i3);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
