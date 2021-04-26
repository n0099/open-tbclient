package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bi implements com.kwad.sdk.core.c<SdkConfigData.TemplateConfigMap> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
        templateConfigMap.downloadPopWindowConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("downloadPopWindowConfig"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "downloadPopWindowConfig", templateConfigMap.downloadPopWindowConfig);
        return jSONObject;
    }
}
