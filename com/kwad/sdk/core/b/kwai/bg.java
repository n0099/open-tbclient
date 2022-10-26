package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class bg implements com.kwad.sdk.core.d {
    public static void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
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

    public static JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = couponActiveConfig.popUpShowTimeSeconds;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "popUpShowTimeSeconds", i);
        }
        String str = couponActiveConfig.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "title", couponActiveConfig.title);
        }
        String str2 = couponActiveConfig.secondTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "secondTitle", couponActiveConfig.secondTitle);
        }
        String str3 = couponActiveConfig.bottomTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        int i2 = couponActiveConfig.videoThreshold;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoThreshold", i2);
        }
        int i3 = couponActiveConfig.videoSeconds;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "videoSeconds", i3);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.r.a(jSONObject, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SdkConfigData.CouponActiveConfig) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SdkConfigData.CouponActiveConfig) bVar, jSONObject);
    }
}
