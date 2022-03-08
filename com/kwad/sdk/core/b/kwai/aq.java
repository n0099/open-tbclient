package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.contentalliance.coupon.model.CouponStatus;
import com.kwad.sdk.contentalliance.coupon.model.CouponStatusInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aq implements com.kwad.sdk.core.d<CouponStatus> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(CouponStatus couponStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponStatus.couponActiveConfig = new SdkConfigData.CouponActiveConfig();
        couponStatus.couponActiveConfig.parseJson(jSONObject.optJSONObject("couponActiveConfig"));
        couponStatus.couponStatusInfo = new CouponStatusInfo();
        couponStatus.couponStatusInfo.parseJson(jSONObject.optJSONObject("couponStatusInfo"));
        couponStatus.currentWatchVideoCount = jSONObject.optInt("currentWatchVideoCount");
        couponStatus.winningTimes = jSONObject.optInt("winningTimes");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(CouponStatus couponStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "couponActiveConfig", couponStatus.couponActiveConfig);
        com.kwad.sdk.utils.t.a(jSONObject, "couponStatusInfo", couponStatus.couponStatusInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "currentWatchVideoCount", couponStatus.currentWatchVideoCount);
        com.kwad.sdk.utils.t.a(jSONObject, "winningTimes", couponStatus.winningTimes);
        return jSONObject;
    }
}
