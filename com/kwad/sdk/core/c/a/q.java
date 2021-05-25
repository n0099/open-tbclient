package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.g.a.h;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q implements com.kwad.sdk.core.c<h.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.f32256a = jSONObject.optInt("streamType");
        aVar.f32257b = jSONObject.optInt("maxVolume");
        aVar.f32258c = jSONObject.optInt("minVolume");
        aVar.f32259d = jSONObject.optInt("currentVolume");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "streamType", aVar.f32256a);
        com.kwad.sdk.utils.o.a(jSONObject, "maxVolume", aVar.f32257b);
        com.kwad.sdk.utils.o.a(jSONObject, "minVolume", aVar.f32258c);
        com.kwad.sdk.utils.o.a(jSONObject, "currentVolume", aVar.f32259d);
        return jSONObject;
    }
}
