package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bf implements com.kwad.sdk.core.d<SdkConfigData.CouponActiveConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        couponActiveConfig.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            couponActiveConfig.title = "";
        }
        couponActiveConfig.secondTitle = jSONObject.optString("secondTitle");
        if (jSONObject.opt("secondTitle") == JSONObject.NULL) {
            couponActiveConfig.secondTitle = "";
        }
        couponActiveConfig.bottomTitle = jSONObject.optString("bottomTitle");
        if (jSONObject.opt("bottomTitle") == JSONObject.NULL) {
            couponActiveConfig.bottomTitle = "";
        }
        couponActiveConfig.videoThreshold = jSONObject.optInt("videoThreshold");
        couponActiveConfig.videoSeconds = jSONObject.optInt("videoSeconds");
        TemplateConfig templateConfig = new TemplateConfig();
        couponActiveConfig.couponOpenConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        TemplateConfig templateConfig2 = new TemplateConfig();
        couponActiveConfig.couponInfoConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        ActivityInfo activityInfo = new ActivityInfo();
        couponActiveConfig.activityInfo = activityInfo;
        activityInfo.parseJson(jSONObject.optJSONObject("activityInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "popUpShowTimeSeconds", couponActiveConfig.popUpShowTimeSeconds);
        com.kwad.sdk.utils.r.a(jSONObject, "title", couponActiveConfig.title);
        com.kwad.sdk.utils.r.a(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        com.kwad.sdk.utils.r.a(jSONObject, "videoThreshold", couponActiveConfig.videoThreshold);
        com.kwad.sdk.utils.r.a(jSONObject, "videoSeconds", couponActiveConfig.videoSeconds);
        com.kwad.sdk.utils.r.a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        a2(couponActiveConfig, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        return b2(couponActiveConfig, jSONObject);
    }
}
