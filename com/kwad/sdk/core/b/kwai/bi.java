package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi implements com.kwad.sdk.core.d<a.C2116a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C2116a c2116a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2116a.a = jSONObject.optInt("code");
        c2116a.f56077b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2116a.f56077b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2116a c2116a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c2116a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c2116a.f56077b);
        return jSONObject;
    }
}
