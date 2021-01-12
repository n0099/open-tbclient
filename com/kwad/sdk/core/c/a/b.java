package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.kwad.sdk.core.c<a.C1104a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(a.C1104a c1104a) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "clickActionButton", c1104a.f9558a);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(a.C1104a c1104a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1104a.f9558a = jSONObject.optBoolean("clickActionButton");
    }
}
