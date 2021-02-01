package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s implements com.kwad.sdk.core.c<AdStyleInfo.FeedAdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdStyleInfo.FeedAdInfo feedAdInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        com.kwad.sdk.utils.o.a(jSONObject, "heightRatio", feedAdInfo.heightRatio);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedAdInfo.templateConfig = jSONObject.optString("templateConfig");
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }
}
