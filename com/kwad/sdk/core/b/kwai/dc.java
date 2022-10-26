package com.kwad.sdk.core.b.kwai;

import com.kwad.components.core.webview.jshandler.ag;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dc implements com.kwad.sdk.core.d {
    public static void a(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gJ = jSONObject.optInt("itemClickType");
    }

    public static JSONObject b(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.gJ;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "itemClickType", i);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ag.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ag.a) bVar, jSONObject);
    }
}
