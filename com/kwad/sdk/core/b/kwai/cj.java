package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cj implements com.kwad.sdk.core.d<b.C2117b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.C2117b c2117b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2117b.a = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            c2117b.a = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.C2117b c2117b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "payload", c2117b.a);
        return jSONObject;
    }
}
