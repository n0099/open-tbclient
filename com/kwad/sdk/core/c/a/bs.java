package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bs implements com.kwad.sdk.core.c<o.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f32993a = jSONObject.optInt("status");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "status", aVar.f32993a);
        return jSONObject;
    }
}
