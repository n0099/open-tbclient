package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.b;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r implements com.kwad.sdk.core.c<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(b.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "code", aVar.f34396a);
        com.kwad.sdk.utils.o.a(jSONObject, "msg", aVar.f34397b);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f34396a = jSONObject.optInt("code");
        aVar.f34397b = jSONObject.optString("msg");
    }
}
