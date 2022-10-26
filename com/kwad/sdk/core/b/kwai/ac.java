package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ac implements com.kwad.sdk.core.d {
    public static void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
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

    public static JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adTrackInfo.type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdTrackInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdTrackInfo) bVar, jSONObject);
    }
}
