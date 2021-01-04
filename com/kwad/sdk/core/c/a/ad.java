package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ad implements com.kwad.sdk.core.c<SdkConfigData.TemplateConfigMap> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(SdkConfigData.TemplateConfigMap templateConfigMap) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "downloadPopWindowConfig", templateConfigMap.downloadPopWindowConfig);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfigMap.downloadPopWindowConfig = new SdkConfigData.TemplateConfig();
        templateConfigMap.downloadPopWindowConfig.parseJson(jSONObject.optJSONObject("downloadPopWindowConfig"));
    }
}
