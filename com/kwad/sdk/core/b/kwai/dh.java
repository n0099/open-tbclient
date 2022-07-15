package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dh implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTemplate> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTemplate.templateUrl = jSONObject.optString("templateUrl");
        if (jSONObject.opt("templateUrl") == JSONObject.NULL) {
            matrixTemplate.templateUrl = "";
        }
        matrixTemplate.templateVersion = jSONObject.optString("templateVersion");
        if (jSONObject.opt("templateVersion") == JSONObject.NULL) {
            matrixTemplate.templateVersion = "";
        }
        matrixTemplate.templateVersionCode = jSONObject.optLong("templateVersionCode");
        matrixTemplate.templateMd5 = jSONObject.optString("templateMd5");
        if (jSONObject.opt("templateMd5") == JSONObject.NULL) {
            matrixTemplate.templateMd5 = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        com.kwad.sdk.utils.r.a(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        com.kwad.sdk.utils.r.a(jSONObject, "templateVersionCode", matrixTemplate.templateVersionCode);
        com.kwad.sdk.utils.r.a(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        a2(matrixTemplate, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        return b2(matrixTemplate, jSONObject);
    }
}
