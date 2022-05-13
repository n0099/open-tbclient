package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cj implements com.kwad.sdk.core.d<b.C0312b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.C0312b c0312b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0312b.a = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            c0312b.a = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.C0312b c0312b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "payload", c0312b.a);
        return jSONObject;
    }
}
