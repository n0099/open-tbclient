package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.c<l.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(l.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "progress", aVar.f35124a);
        com.kwad.sdk.utils.o.a(jSONObject, "status", aVar.f35125b);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f35124a = jSONObject.optDouble("progress");
        aVar.f35125b = jSONObject.optInt("status");
    }
}
