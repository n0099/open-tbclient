package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.webview.jshandler.m;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bo implements com.kwad.sdk.core.d<m.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.a = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(m.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "creativeId", bVar.a);
        return jSONObject;
    }
}
