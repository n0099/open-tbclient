package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bi implements com.kwad.sdk.core.d<a.C2105a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C2105a c2105a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2105a.a = jSONObject.optInt("code");
        c2105a.f54594b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2105a.f54594b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2105a c2105a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c2105a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c2105a.f54594b);
        return jSONObject;
    }
}
