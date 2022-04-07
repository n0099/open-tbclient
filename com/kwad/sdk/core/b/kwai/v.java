package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v implements com.kwad.sdk.core.d<AdInfo.AdTrackInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "type", adTrackInfo.type);
        com.kwad.sdk.utils.t.a(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }
}
