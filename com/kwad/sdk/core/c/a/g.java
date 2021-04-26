package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.core.c<AdInfo.AdMaterialInfo> {
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
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdInfo.AdMaterialInfo.MaterialFeature materialFeature = new AdInfo.AdMaterialInfo.MaterialFeature();
                materialFeature.parseJson(optJSONArray.optJSONObject(i2));
                adMaterialInfo.materialFeatureList.add(materialFeature);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.o.a(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        return jSONObject;
    }
}
