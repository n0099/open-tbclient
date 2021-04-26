package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PreloadData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ba implements com.kwad.sdk.core.c<PreloadData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preloadData.isPreload = jSONObject.optBoolean("isPreload");
        preloadData.mCacheTime = jSONObject.optLong("mCacheTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "isPreload", preloadData.isPreload);
        com.kwad.sdk.utils.o.a(jSONObject, "mCacheTime", preloadData.mCacheTime);
        return jSONObject;
    }
}
