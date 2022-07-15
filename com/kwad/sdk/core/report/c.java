package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class c extends com.kwad.sdk.core.response.kwai.a {
    public String a;
    public JSONObject b;

    public final JSONObject a() {
        JSONObject json = toJson();
        if (this.b != null) {
            json.remove("mMergeJsonData");
            com.kwad.sdk.utils.s.a(json, this.b);
        }
        return json;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.b = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.b;
        if (jSONObject2 != null) {
            com.kwad.sdk.utils.r.a(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }
}
