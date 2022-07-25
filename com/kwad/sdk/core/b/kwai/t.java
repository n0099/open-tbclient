package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class t implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMaterialInfo.materialType = jSONObject.optInt("materialType", new Integer("2").intValue());
        adMaterialInfo.videoVoice = jSONObject.optBoolean("videoVoice", new Boolean("false").booleanValue());
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "materialType", adMaterialInfo.materialType);
        com.kwad.sdk.utils.r.putValue(jSONObject, "videoVoice", adMaterialInfo.videoVoice);
        com.kwad.sdk.utils.r.putValue(jSONObject, "materialFeature", adMaterialInfo.materialFeatureList);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        a2(adMaterialInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo adMaterialInfo, JSONObject jSONObject) {
        return b2(adMaterialInfo, jSONObject);
    }
}
