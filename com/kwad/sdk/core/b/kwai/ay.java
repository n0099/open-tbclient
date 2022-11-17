package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ay implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        a2(complianceInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return b2(complianceInfo, jSONObject);
    }
}
