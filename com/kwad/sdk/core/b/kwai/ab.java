package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.request.model.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ab implements com.kwad.sdk.core.d<g.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("streamType");
        aVar.f54735b = jSONObject.optInt("maxVolume");
        aVar.f54736c = jSONObject.optInt("minVolume");
        aVar.f54737d = jSONObject.optInt("currentVolume");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(g.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "streamType", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "maxVolume", aVar.f54735b);
        com.kwad.sdk.utils.t.a(jSONObject, "minVolume", aVar.f54736c);
        com.kwad.sdk.utils.t.a(jSONObject, "currentVolume", aVar.f54737d);
        return jSONObject;
    }
}
