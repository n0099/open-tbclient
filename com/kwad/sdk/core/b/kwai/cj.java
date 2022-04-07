package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cj implements com.kwad.sdk.core.d<b.C0313b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.C0313b c0313b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0313b.a = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            c0313b.a = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.C0313b c0313b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "payload", c0313b.a);
        return jSONObject;
    }
}
