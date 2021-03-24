package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.c<a.C0394a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(a.C0394a c0394a) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "clickActionButton", c0394a.f34317a);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(a.C0394a c0394a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0394a.f34317a = jSONObject.optBoolean("clickActionButton");
    }
}
