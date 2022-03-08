package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.HotspotInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bv implements com.kwad.sdk.core.d<HotspotInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hotspotInfo.trendId = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        hotspotInfo.name = jSONObject.optString("name");
        if (jSONObject.opt("name") == JSONObject.NULL) {
            hotspotInfo.name = "";
        }
        hotspotInfo.viewCount = jSONObject.optLong("viewCount");
        hotspotInfo.offlineTime = jSONObject.optLong("offlineTime");
        hotspotInfo.photoCount = jSONObject.optInt("photoCount");
        hotspotInfo.coverUrl = jSONObject.optString("coverUrl");
        if (jSONObject.opt("coverUrl") == JSONObject.NULL) {
            hotspotInfo.coverUrl = "";
        }
        hotspotInfo.iconUrl = jSONObject.optString("iconUrl");
        if (jSONObject.opt("iconUrl") == JSONObject.NULL) {
            hotspotInfo.iconUrl = "";
        }
        hotspotInfo.rank = jSONObject.optInt("rank");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_TREND_ID, hotspotInfo.trendId);
        com.kwad.sdk.utils.t.a(jSONObject, "name", hotspotInfo.name);
        com.kwad.sdk.utils.t.a(jSONObject, "viewCount", hotspotInfo.viewCount);
        com.kwad.sdk.utils.t.a(jSONObject, "offlineTime", hotspotInfo.offlineTime);
        com.kwad.sdk.utils.t.a(jSONObject, "photoCount", hotspotInfo.photoCount);
        com.kwad.sdk.utils.t.a(jSONObject, "coverUrl", hotspotInfo.coverUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "iconUrl", hotspotInfo.iconUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "rank", hotspotInfo.rank);
        return jSONObject;
    }
}
