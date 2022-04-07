package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bk implements com.kwad.sdk.core.d<AdStyleInfo.ExtraDisplayInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        extraDisplayInfo.exposeTagInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("exposeTagInfoList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdStyleInfo.ExposeTagInfo exposeTagInfo = new AdStyleInfo.ExposeTagInfo();
                exposeTagInfo.parseJson(optJSONArray.optJSONObject(i));
                extraDisplayInfo.exposeTagInfoList.add(exposeTagInfo);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.ExtraDisplayInfo extraDisplayInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "exposeTagInfoList", extraDisplayInfo.exposeTagInfoList);
        return jSONObject;
    }
}
