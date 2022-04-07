package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o implements com.kwad.sdk.core.d<AdMatrixInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdMatrixInfo.Styles styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles = styles;
        styles.parseJson(jSONObject.optJSONObject("styles"));
        AdMatrixInfo.AdDataV2 adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2 = adDataV2;
        adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.t.a(jSONObject, "adDataV2", adMatrixInfo.adDataV2);
        return jSONObject;
    }
}
