package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PreloadData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dh implements com.kwad.sdk.core.d<PreloadData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preloadData.isPreload = jSONObject.optBoolean("isPreload");
        preloadData.mCacheTime = jSONObject.optLong("mCacheTime");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "isPreload", preloadData.isPreload);
        com.kwad.sdk.utils.t.a(jSONObject, "mCacheTime", preloadData.mCacheTime);
        return jSONObject;
    }
}
