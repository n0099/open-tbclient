package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.u;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ei implements com.kwad.sdk.core.d<u.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("timerName");
        aVar.b = jSONObject.optInt("time");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(u.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "timerName", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "time", aVar.b);
        return jSONObject;
    }
}
