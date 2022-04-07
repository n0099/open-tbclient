package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.TabInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ec implements com.kwad.sdk.core.d<TabInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(TabInfo tabInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tabInfo.tabId = jSONObject.optInt("tabId");
        tabInfo.tabName = jSONObject.optString("tabName");
        if (jSONObject.opt("tabName") == JSONObject.NULL) {
            tabInfo.tabName = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(TabInfo tabInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "tabId", tabInfo.tabId);
        com.kwad.sdk.utils.t.a(jSONObject, "tabName", tabInfo.tabName);
        return jSONObject;
    }
}
