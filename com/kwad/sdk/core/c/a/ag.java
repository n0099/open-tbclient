package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.p;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ag implements com.kwad.sdk.core.c<p.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(p.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "status", aVar.f34403a);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(p.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f34403a = jSONObject.optInt("status");
    }
}
