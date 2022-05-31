package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bi implements com.kwad.sdk.core.d<a.C0306a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C0306a c0306a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0306a.a = jSONObject.optInt("code");
        c0306a.b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c0306a.b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C0306a c0306a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c0306a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c0306a.b);
        return jSONObject;
    }
}
