package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class fr implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfigMap> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfigMap.couponOpenConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        TemplateConfig templateConfig2 = new TemplateConfig();
        templateConfigMap.couponInfoConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        TemplateConfig templateConfig3 = new TemplateConfig();
        templateConfigMap.rewardReflowConfig = templateConfig3;
        templateConfig3.parseJson(jSONObject.optJSONObject("rewardReflowConfig"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardReflowConfig", templateConfigMap.rewardReflowConfig);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        a2(templateConfigMap, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        return b2(templateConfigMap, jSONObject);
    }
}
