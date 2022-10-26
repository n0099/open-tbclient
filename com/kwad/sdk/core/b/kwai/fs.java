package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fs implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
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

    public static JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = templateData.templateShowTime;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateShowTime", j);
        }
        long j2 = templateData.templateDelayTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateDelayTime", j2);
        }
        String str = templateData.data;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "data", templateData.data);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.TemplateData) bVar, jSONObject);
    }
}
