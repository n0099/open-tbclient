package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class an implements com.kwad.sdk.core.d<AdMatrixInfo.BaseMatrixTemplate> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseMatrixTemplate.templateId = jSONObject.optString("templateId");
        if (jSONObject.opt("templateId") == JSONObject.NULL) {
            baseMatrixTemplate.templateId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "templateId", baseMatrixTemplate.templateId);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        a2(baseMatrixTemplate, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate, JSONObject jSONObject) {
        return b2(baseMatrixTemplate, jSONObject);
    }
}
