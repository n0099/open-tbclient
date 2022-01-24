package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ca implements com.kwad.sdk.core.d<i.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.f55692b = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "horizontalShowDuration", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "verticalShowDuration", aVar.f55692b);
        return jSONObject;
    }
}
