package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bi implements com.kwad.sdk.core.d<a.C0314a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C0314a c0314a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0314a.a = jSONObject.optInt("code");
        c0314a.b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c0314a.b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C0314a c0314a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c0314a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c0314a.b);
        return jSONObject;
    }
}
