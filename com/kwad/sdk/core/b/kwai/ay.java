package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ay implements com.kwad.sdk.core.d {
    public static void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    public static JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = complianceInfo.materialJumpType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "materialJumpType", i);
        }
        int i2 = complianceInfo.actionBarType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "actionBarType", i2);
        }
        int i3 = complianceInfo.describeBarType;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "describeBarType", i3);
        }
        int i4 = complianceInfo.titleBarTextSwitch;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "titleBarTextSwitch", i4);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.ComplianceInfo) bVar, jSONObject);
    }
}
