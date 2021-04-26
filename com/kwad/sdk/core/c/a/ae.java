package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.report.b;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ae implements com.kwad.sdk.core.c<b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f33381a = jSONObject.optInt("code");
        aVar.f33382b = jSONObject.optString("msg");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "code", aVar.f33381a);
        com.kwad.sdk.utils.o.a(jSONObject, "msg", aVar.f33382b);
        return jSONObject;
    }
}
