package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.config.item.InsertScreenConfigItem;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bz implements com.kwad.sdk.core.d<InsertScreenConfigItem.InsertScreenConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(InsertScreenConfigItem.InsertScreenConfig insertScreenConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        insertScreenConfig.firstPosition = jSONObject.optInt("firstPosition", new Integer("1").intValue());
        insertScreenConfig.interval = jSONObject.optInt("interval", new Integer("3").intValue());
        insertScreenConfig.threshold = jSONObject.optInt("threshold", new Integer("2").intValue());
        insertScreenConfig.preRequestCount = jSONObject.optInt("preRequestCount", new Integer("2").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(InsertScreenConfigItem.InsertScreenConfig insertScreenConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "firstPosition", insertScreenConfig.firstPosition);
        com.kwad.sdk.utils.t.a(jSONObject, "interval", insertScreenConfig.interval);
        com.kwad.sdk.utils.t.a(jSONObject, "threshold", insertScreenConfig.threshold);
        com.kwad.sdk.utils.t.a(jSONObject, "preRequestCount", insertScreenConfig.preRequestCount);
        return jSONObject;
    }
}
