package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class dn implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTemplate> {
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
        String str = matrixTemplate.templateUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        }
        String str2 = matrixTemplate.templateVersion;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        }
        long j = matrixTemplate.templateVersionCode;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateVersionCode", j);
        }
        String str3 = matrixTemplate.templateMd5;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        }
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
