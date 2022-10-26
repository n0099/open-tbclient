package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fr implements com.kwad.sdk.core.d {
    public static void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
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

    public static JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "rewardReflowConfig", templateConfigMap.rewardReflowConfig);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SdkConfigData.TemplateConfigMap) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SdkConfigData.TemplateConfigMap) bVar, jSONObject);
    }
}
