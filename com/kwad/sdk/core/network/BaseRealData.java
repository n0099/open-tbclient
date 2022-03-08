package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseRealData extends BaseResultData {
    public abstract void parseData(@NonNull JSONObject jSONObject);

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String b2 = com.kwad.sdk.core.a.d.b(jSONObject.optString("data"));
            if (b2 == null || b2.isEmpty()) {
                this.result = 0;
            } else {
                parseData(new JSONObject(b2));
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            this.result = 0;
            this.errorMsg = e2.getMessage();
        }
    }
}
