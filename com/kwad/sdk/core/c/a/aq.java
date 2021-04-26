package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class aq implements com.kwad.sdk.core.c<PageInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "pageType", pageInfo.pageType);
        return jSONObject;
    }
}
