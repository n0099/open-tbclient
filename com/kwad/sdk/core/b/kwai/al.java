package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.reward.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class al implements com.kwad.sdk.core.d<j.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("style");
        aVar.f57340b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            aVar.f57340b = "";
        }
        aVar.f57341c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            aVar.f57341c = "";
        }
        aVar.f57342d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            aVar.f57342d = "";
        }
        aVar.f57345g = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            aVar.f57345g = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", aVar.f57340b);
        com.kwad.sdk.utils.t.a(jSONObject, "closeBtnText", aVar.f57341c);
        com.kwad.sdk.utils.t.a(jSONObject, "continueBtnText", aVar.f57342d);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", aVar.f57345g);
        return jSONObject;
    }
}
