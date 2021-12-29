package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ef implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfig> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(SdkConfigData.TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString("h5Url");
        if (jSONObject.opt("h5Url") == JSONObject.NULL) {
            templateConfig.h5Url = "";
        }
        templateConfig.h5Version = jSONObject.optString("h5Version");
        if (jSONObject.opt("h5Version") == JSONObject.NULL) {
            templateConfig.h5Version = "";
        }
        templateConfig.h5Checksum = jSONObject.optString("h5Checksum");
        if (jSONObject.opt("h5Checksum") == JSONObject.NULL) {
            templateConfig.h5Checksum = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(SdkConfigData.TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "h5Url", templateConfig.h5Url);
        com.kwad.sdk.utils.t.a(jSONObject, "h5Version", templateConfig.h5Version);
        com.kwad.sdk.utils.t.a(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        return jSONObject;
    }
}
