package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ct implements com.kwad.sdk.core.d<PageInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "pageType", pageInfo.pageType);
        return jSONObject;
    }
}
