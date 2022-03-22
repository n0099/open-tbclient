package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.HotspotInfo;
import com.kwad.sdk.core.response.model.HotspotListData;
import com.kwad.sdk.core.response.model.TabInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bw implements com.kwad.sdk.core.d<HotspotListData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(HotspotListData hotspotListData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hotspotListData.trends = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("trends");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                HotspotInfo hotspotInfo = new HotspotInfo();
                hotspotInfo.parseJson(optJSONArray.optJSONObject(i));
                hotspotListData.trends.add(hotspotInfo);
            }
        }
        hotspotListData.tabList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tabList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(optJSONArray2.optJSONObject(i2));
                hotspotListData.tabList.add(tabInfo);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(HotspotListData hotspotListData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "trends", hotspotListData.trends);
        com.kwad.sdk.utils.t.a(jSONObject, "tabList", hotspotListData.tabList);
        return jSONObject;
    }
}
