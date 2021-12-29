package com.kwad.sdk.core.b.kwai;

import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kwad.sdk.contentalliance.coupon.model.CouponStatusInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ar implements com.kwad.sdk.core.d<CouponStatusInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponStatusInfo.statusCode = jSONObject.optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, new Integer("-1").intValue());
        couponStatusInfo.statusName = jSONObject.optString("statusName");
        if (jSONObject.opt("statusName") == JSONObject.NULL) {
            couponStatusInfo.statusName = "";
        }
        couponStatusInfo.currTotalAmount = jSONObject.optDouble("currTotalAmount");
        couponStatusInfo.couponLeftTimes = jSONObject.optInt("couponLeftTimes");
        couponStatusInfo.isNewUser = jSONObject.optBoolean("isNewUser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CouponStatusInfo couponStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, EnterDxmPayServiceAction.SERVICE_STATUS_CODE, couponStatusInfo.statusCode);
        com.kwad.sdk.utils.t.a(jSONObject, "statusName", couponStatusInfo.statusName);
        com.kwad.sdk.utils.t.a(jSONObject, "currTotalAmount", couponStatusInfo.currTotalAmount);
        com.kwad.sdk.utils.t.a(jSONObject, "couponLeftTimes", couponStatusInfo.couponLeftTimes);
        com.kwad.sdk.utils.t.a(jSONObject, "isNewUser", couponStatusInfo.isNewUser);
        return jSONObject;
    }
}
