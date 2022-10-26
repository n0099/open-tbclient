package com.kwad.sdk.core.report;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class c extends com.kwad.sdk.core.response.kwai.a {
    public String ZR;
    public JSONObject ZS;

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.ZS = jSONObject.optJSONObject("mMergeJsonData");
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.ZS;
        if (jSONObject2 != null) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mMergeJsonData", jSONObject2);
        }
    }

    public final JSONObject ut() {
        JSONObject json = toJson();
        if (this.ZS != null) {
            json.remove("mMergeJsonData");
            com.kwad.sdk.utils.s.merge(json, this.ZS);
        }
        return json;
    }
}
