package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cj implements com.kwad.sdk.core.d<b.C1973b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(b.C1973b c1973b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1973b.a = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            c1973b.a = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(b.C1973b c1973b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "payload", c1973b.a);
        return jSONObject;
    }
}
