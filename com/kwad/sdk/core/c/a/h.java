package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.l;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h implements com.kwad.sdk.core.c<l.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(l.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "progress", aVar.f6357a);
        com.kwad.sdk.utils.o.a(jSONObject, "status", aVar.b);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f6357a = jSONObject.optDouble("progress");
        aVar.b = jSONObject.optInt("status");
    }
}
