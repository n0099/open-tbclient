package com.kwad.sdk.core.b.kwai;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mv = jSONObject.optBoolean("clickActionButton");
        aVar.Mx = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.My = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.DZ = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    public static JSONObject b(com.kwad.sdk.core.webview.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Mv;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.Mx;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "area", i);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.My);
        com.kwad.sdk.utils.r.putValue(jSONObject, "needReport", aVar.DZ);
        com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", aVar.adStyle);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.a.a.a) bVar, jSONObject);
    }
}
