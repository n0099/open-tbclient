package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi implements com.kwad.sdk.core.d<a.C2093a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C2093a c2093a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2093a.a = jSONObject.optInt("code");
        c2093a.f58233b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2093a.f58233b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2093a c2093a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c2093a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c2093a.f58233b);
        return jSONObject;
    }
}
