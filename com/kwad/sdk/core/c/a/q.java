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
        aVar.f32327a = jSONObject.optInt("streamType");
        aVar.f32328b = jSONObject.optInt("maxVolume");
        aVar.f32329c = jSONObject.optInt("minVolume");
        aVar.f32330d = jSONObject.optInt("currentVolume");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "streamType", aVar.f32327a);
        com.kwad.sdk.utils.o.a(jSONObject, "maxVolume", aVar.f32328b);
        com.kwad.sdk.utils.o.a(jSONObject, "minVolume", aVar.f32329c);
        com.kwad.sdk.utils.o.a(jSONObject, "currentVolume", aVar.f32330d);
        return jSONObject;
    }
}
