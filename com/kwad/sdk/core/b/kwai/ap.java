package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.CouponInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ap implements com.kwad.sdk.core.d<CouponInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponInfo.displayName = jSONObject.optString("displayName");
        if (jSONObject.opt("displayName") == JSONObject.NULL) {
            couponInfo.displayName = "";
        }
        couponInfo.displayTitle = jSONObject.optString("displayTitle");
        if (jSONObject.opt("displayTitle") == JSONObject.NULL) {
            couponInfo.displayTitle = "";
        }
        couponInfo.displayValue = jSONObject.optString("displayValue");
        if (jSONObject.opt("displayValue") == JSONObject.NULL) {
            couponInfo.displayValue = "";
        }
        couponInfo.displayBase = jSONObject.optString("displayBase");
        if (jSONObject.opt("displayBase") == JSONObject.NULL) {
            couponInfo.displayBase = "";
        }
        couponInfo.displayType = jSONObject.optString("displayType");
        if (jSONObject.opt("displayType") == JSONObject.NULL) {
            couponInfo.displayType = "";
        }
        couponInfo.displayActionWords = jSONObject.optString("displayActionWords");
        if (jSONObject.opt("displayActionWords") == JSONObject.NULL) {
            couponInfo.displayActionWords = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "displayName", couponInfo.displayName);
        com.kwad.sdk.utils.t.a(jSONObject, "displayTitle", couponInfo.displayTitle);
        com.kwad.sdk.utils.t.a(jSONObject, "displayValue", couponInfo.displayValue);
        com.kwad.sdk.utils.t.a(jSONObject, "displayBase", couponInfo.displayBase);
        com.kwad.sdk.utils.t.a(jSONObject, "displayType", couponInfo.displayType);
        com.kwad.sdk.utils.t.a(jSONObject, "displayActionWords", couponInfo.displayActionWords);
        return jSONObject;
    }
}
