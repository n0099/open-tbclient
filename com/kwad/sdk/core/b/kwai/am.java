package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class am implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "materialJumpType", complianceInfo.materialJumpType);
        com.kwad.sdk.utils.t.a(jSONObject, "actionBarType", complianceInfo.actionBarType);
        com.kwad.sdk.utils.t.a(jSONObject, "describeBarType", complianceInfo.describeBarType);
        com.kwad.sdk.utils.t.a(jSONObject, "titleBarTextSwitch", complianceInfo.titleBarTextSwitch);
        return jSONObject;
    }
}
