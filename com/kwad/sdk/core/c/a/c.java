package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.webview.jshandler.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.c<a.C0374a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(a.C0374a c0374a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0374a.f32832a = jSONObject.optBoolean("clickActionButton");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(a.C0374a c0374a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "clickActionButton", c0374a.f32832a);
        return jSONObject;
    }
}
