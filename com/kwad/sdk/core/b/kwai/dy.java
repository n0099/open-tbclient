package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.x;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dy implements com.kwad.sdk.core.d {
    public static void a(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.errorMsg = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            aVar.errorMsg = "";
        }
    }

    public static JSONObject b(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "status", i);
        }
        String str = aVar.errorMsg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "errorMsg", aVar.errorMsg);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((x.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((x.a) bVar, jSONObject);
    }
}
