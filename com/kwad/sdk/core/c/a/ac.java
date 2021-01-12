package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac implements com.kwad.sdk.core.c<SdkConfigData.TemplateConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(SdkConfigData.TemplateConfig templateConfig) {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.o.a(jSONObject, "h5Url", templateConfig.h5Url);
        com.kwad.sdk.utils.o.a(jSONObject, "h5Version", templateConfig.h5Version);
        com.kwad.sdk.utils.o.a(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(SdkConfigData.TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString("h5Url");
        templateConfig.h5Version = jSONObject.optString("h5Version");
        templateConfig.h5Checksum = jSONObject.optString("h5Checksum");
    }
}
