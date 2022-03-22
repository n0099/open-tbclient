package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bi implements com.kwad.sdk.core.d<a.C1966a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C1966a c1966a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1966a.a = jSONObject.optInt("code");
        c1966a.f39703b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c1966a.f39703b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C1966a c1966a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c1966a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c1966a.f39703b);
        return jSONObject;
    }
}
