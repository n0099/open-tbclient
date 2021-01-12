package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r implements com.kwad.sdk.core.c<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(b.a aVar) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "code", aVar.f9395a);
        com.kwad.sdk.utils.o.a(jSONObject, "msg", aVar.f9396b);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f9395a = jSONObject.optInt("code");
        aVar.f9396b = jSONObject.optString("msg");
    }
}
