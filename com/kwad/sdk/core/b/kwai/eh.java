package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class eh implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateData.templateShowTime = jSONObject.optLong("templateShowTime");
        templateData.templateDelayTime = jSONObject.optLong("templateDelayTime");
        templateData.data = jSONObject.optString("data");
        if (jSONObject.opt("data") == JSONObject.NULL) {
            templateData.data = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "templateShowTime", templateData.templateShowTime);
        com.kwad.sdk.utils.t.a(jSONObject, "templateDelayTime", templateData.templateDelayTime);
        com.kwad.sdk.utils.t.a(jSONObject, "data", templateData.data);
        return jSONObject;
    }
}
