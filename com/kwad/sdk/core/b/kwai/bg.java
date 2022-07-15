package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.CouponInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bg implements com.kwad.sdk.core.d<CouponInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(CouponInfo couponInfo, JSONObject jSONObject) {
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
        couponInfo.displayDiscount = jSONObject.optString("displayDiscount");
        if (jSONObject.opt("displayDiscount") == JSONObject.NULL) {
            couponInfo.displayDiscount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "displayName", couponInfo.displayName);
        com.kwad.sdk.utils.r.a(jSONObject, "displayTitle", couponInfo.displayTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "displayValue", couponInfo.displayValue);
        com.kwad.sdk.utils.r.a(jSONObject, "displayBase", couponInfo.displayBase);
        com.kwad.sdk.utils.r.a(jSONObject, "displayType", couponInfo.displayType);
        com.kwad.sdk.utils.r.a(jSONObject, "displayActionWords", couponInfo.displayActionWords);
        com.kwad.sdk.utils.r.a(jSONObject, "displayDiscount", couponInfo.displayDiscount);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(CouponInfo couponInfo, JSONObject jSONObject) {
        a2(couponInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(CouponInfo couponInfo, JSONObject jSONObject) {
        return b2(couponInfo, jSONObject);
    }
}
