package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi implements com.kwad.sdk.core.d<a.C2110a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C2110a c2110a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2110a.a = jSONObject.optInt("code");
        c2110a.f56032b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2110a.f56032b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2110a c2110a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c2110a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c2110a.f56032b);
        return jSONObject;
    }
}
