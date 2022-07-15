package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fk implements com.kwad.sdk.core.d<AdMatrixInfo.TemplateData> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
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

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "templateShowTime", templateData.templateShowTime);
        com.kwad.sdk.utils.r.a(jSONObject, "templateDelayTime", templateData.templateDelayTime);
        com.kwad.sdk.utils.r.a(jSONObject, "data", templateData.data);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        a2(templateData, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.TemplateData templateData, JSONObject jSONObject) {
        return b2(templateData, jSONObject);
    }
}
