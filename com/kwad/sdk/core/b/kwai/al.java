package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.reward.j;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class al implements com.kwad.sdk.core.d<j.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("style");
        aVar.b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            aVar.b = "";
        }
        aVar.c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            aVar.c = "";
        }
        aVar.d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            aVar.d = "";
        }
        aVar.g = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            aVar.g = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", aVar.b);
        com.kwad.sdk.utils.t.a(jSONObject, "closeBtnText", aVar.c);
        com.kwad.sdk.utils.t.a(jSONObject, "continueBtnText", aVar.d);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", aVar.g);
        return jSONObject;
    }
}
