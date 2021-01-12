package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e implements com.kwad.sdk.core.c<AdInfo.AdMaterialInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(AdInfo.AdMaterialInfo adMaterialInfo) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.o.a(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMaterialInfo.materialType = jSONObject.optInt("materialType", new Integer("2").intValue());
        adMaterialInfo.materialFeatureList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("materialFeature");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = new AdInfo.AdMaterialInfo.MaterialFeature();
                materialFeature.parseJson(optJSONArray.optJSONObject(i));
                adMaterialInfo.materialFeatureList.add(materialFeature);
            }
        }
    }
}
