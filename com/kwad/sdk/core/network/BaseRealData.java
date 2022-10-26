package com.kwad.sdk.core.network;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseRealData extends BaseResultData {
    public abstract void parseData(JSONObject jSONObject);

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = com.kwad.sdk.core.a.d.getResponseData(jSONObject.optString("data"));
            if (responseData == null || responseData.isEmpty()) {
                this.result = 0;
            } else {
                parseData(new JSONObject(responseData));
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            this.result = 0;
            this.errorMsg = e.getMessage();
        }
    }
}
