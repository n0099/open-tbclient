package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bj implements com.kwad.sdk.core.d<AdStyleInfo.ExposeTagInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        exposeTagInfo.text = jSONObject.optString("text");
        if (jSONObject.opt("text") == JSONObject.NULL) {
            exposeTagInfo.text = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.ExposeTagInfo exposeTagInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "text", exposeTagInfo.text);
        return jSONObject;
    }
}
