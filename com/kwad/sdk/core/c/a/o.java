package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o implements com.kwad.sdk.core.c<l.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f32899a = jSONObject.optDouble("progress");
        aVar.f32900b = jSONObject.optInt("status");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "progress", aVar.f32899a);
        com.kwad.sdk.utils.o.a(jSONObject, "status", aVar.f32900b);
        return jSONObject;
    }
}
