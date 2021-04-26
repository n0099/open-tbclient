package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bj implements com.kwad.sdk.core.c<TrendInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(TrendInfo trendInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        trendInfo.trendId = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        trendInfo.name = jSONObject.optString("name");
        trendInfo.viewCount = jSONObject.optLong("viewCount");
        trendInfo.offlineTime = jSONObject.optLong("offlineTime");
        trendInfo.photoCount = jSONObject.optInt("photoCount");
        trendInfo.coverUrl = jSONObject.optString("coverUrl");
        trendInfo.iconUrl = jSONObject.optString("iconUrl");
        trendInfo.rank = jSONObject.optInt("rank");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(TrendInfo trendInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, URLPackage.KEY_TREND_ID, trendInfo.trendId);
        com.kwad.sdk.utils.o.a(jSONObject, "name", trendInfo.name);
        com.kwad.sdk.utils.o.a(jSONObject, "viewCount", trendInfo.viewCount);
        com.kwad.sdk.utils.o.a(jSONObject, "offlineTime", trendInfo.offlineTime);
        com.kwad.sdk.utils.o.a(jSONObject, "photoCount", trendInfo.photoCount);
        com.kwad.sdk.utils.o.a(jSONObject, "coverUrl", trendInfo.coverUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "iconUrl", trendInfo.iconUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "rank", trendInfo.rank);
        return jSONObject;
    }
}
