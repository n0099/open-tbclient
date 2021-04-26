package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.core.c<AdInfo.AdTrackInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i2));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "type", adTrackInfo.type);
        com.kwad.sdk.utils.o.a(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }
}
