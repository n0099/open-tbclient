package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.t;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bi implements com.kwad.sdk.core.d {
    public static void a(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Mv = jSONObject.optBoolean("clickActionButton");
        aVar.Mw = jSONObject.optString("adTemplate");
        if (jSONObject.opt("adTemplate") == JSONObject.NULL) {
            aVar.Mw = "";
        }
        aVar.Mx = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.a.a.c cVar = new com.kwad.sdk.core.webview.a.a.c();
        aVar.My = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    public static JSONObject b(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Mv;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickActionButton", z);
        }
        String str = aVar.Mw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adTemplate", aVar.Mw);
        }
        int i = aVar.Mx;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "area", i);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "logParam", aVar.My);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((t.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((t.a) bVar, jSONObject);
    }
}
