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
        aVar.f40825b = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            aVar.f40825b = "";
        }
        aVar.f40826c = jSONObject.optString("closeBtnText");
        if (jSONObject.opt("closeBtnText") == JSONObject.NULL) {
            aVar.f40826c = "";
        }
        aVar.f40827d = jSONObject.optString("continueBtnText");
        if (jSONObject.opt("continueBtnText") == JSONObject.NULL) {
            aVar.f40827d = "";
        }
        aVar.f40830g = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            aVar.f40830g = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "style", aVar.a);
        com.kwad.sdk.utils.t.a(jSONObject, "title", aVar.f40825b);
        com.kwad.sdk.utils.t.a(jSONObject, "closeBtnText", aVar.f40826c);
        com.kwad.sdk.utils.t.a(jSONObject, "continueBtnText", aVar.f40827d);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", aVar.f40830g);
        return jSONObject;
    }
}
