package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fn implements com.kwad.sdk.core.d {
    public static void a(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styles.templateList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templates");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdMatrixInfo.MatrixTemplate matrixTemplate = new AdMatrixInfo.MatrixTemplate();
                matrixTemplate.parseJson(optJSONArray.optJSONObject(i));
                styles.templateList.add(matrixTemplate);
            }
        }
    }

    public static JSONObject b(AdMatrixInfo.Styles styles, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "templates", styles.templateList);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.Styles) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.Styles) bVar, jSONObject);
    }
}
