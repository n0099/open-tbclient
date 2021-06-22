package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.c<a.C0398a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(a.C0398a c0398a) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "clickActionButton", c0398a.f35059a);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(a.C0398a c0398a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0398a.f35059a = jSONObject.optBoolean("clickActionButton");
    }
}
