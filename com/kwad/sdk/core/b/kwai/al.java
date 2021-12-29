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
        aVar.f59547b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            aVar.f59547b = "";
        }
        aVar.f59548c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            aVar.f59548c = "";
        }
        aVar.f59549d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            aVar.f59549d = "";
        }
        aVar.f59552g = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            aVar.f59552g = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", aVar.f59547b);
        com.kwad.sdk.utils.t.a(jSONObject, "closeBtnText", aVar.f59548c);
        com.kwad.sdk.utils.t.a(jSONObject, "continueBtnText", aVar.f59549d);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", aVar.f59552g);
        return jSONObject;
    }
}
