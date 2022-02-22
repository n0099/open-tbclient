package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bi implements com.kwad.sdk.core.d<a.C2126a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(a.C2126a c2126a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c2126a.a = jSONObject.optInt("code");
        c2126a.f56244b = jSONObject.optString("msg");
        if (jSONObject.opt("msg") == JSONObject.NULL) {
            c2126a.f56244b = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(a.C2126a c2126a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "code", c2126a.a);
        com.kwad.sdk.utils.t.a(jSONObject, "msg", c2126a.f56244b);
        return jSONObject;
    }
}
