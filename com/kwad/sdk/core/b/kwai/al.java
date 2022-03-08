package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.reward.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class al implements com.kwad.sdk.core.d<j.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.a = jSONObject.optInt("style");
        aVar.f55857b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            aVar.f55857b = "";
        }
        aVar.f55858c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            aVar.f55858c = "";
        }
        aVar.f55859d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            aVar.f55859d = "";
        }
        aVar.f55862g = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            aVar.f55862g = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", aVar.f55857b);
        com.kwad.sdk.utils.t.a(jSONObject, "closeBtnText", aVar.f55858c);
        com.kwad.sdk.utils.t.a(jSONObject, "continueBtnText", aVar.f55859d);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", aVar.f55862g);
        return jSONObject;
    }
}
