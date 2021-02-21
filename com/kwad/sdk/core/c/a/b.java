package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.kwad.sdk.core.c<a.C1110a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(a.C1110a c1110a) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "clickActionButton", c1110a.f9560a);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(a.C1110a c1110a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1110a.f9560a = jSONObject.optBoolean("clickActionButton");
    }
}
