package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    public static final int DEFAULT_SPLASH_TIME_OUT = 5000;
    public static final long serialVersionUID = -7796837168148055391L;
    public JSONObject abConfig;
    public JSONObject appConfig;
    public JSONObject mDataJsonObj;
    public JSONObject mOriginalObjData;
    public long requestInterval = 3600;
    public List<com.kwad.sdk.c.kwai.c> h5PreloadConfigs = new ArrayList();
    public TemplateConfig templateConfig = new TemplateConfig();
    public TemplateConfig splashConfig = new TemplateConfig();
    public TemplateConfigMap templateConfigMap = new TemplateConfigMap();
    public CouponActiveConfig couponActiveConfig = new CouponActiveConfig();

    /* loaded from: classes7.dex */
    public static class CouponActiveConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 6375241669684789095L;
        public ActivityInfo activityInfo;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public int popUpShowTimeSeconds;
        public int videoSeconds;
        public int videoThreshold;
        public String title = "抽红包兑奖";
        public String secondTitle = "累计到100元可兑换京东卡";
        public String bottomTitle = "刷满5个视频抽红包，每个视频观看>5秒";
    }

    /* loaded from: classes7.dex */
    public static class TemplateConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -6943205584670122269L;
        public String h5Checksum;
        public String h5Url;
        public String h5Version;

        public boolean notEmpty() {
            return (TextUtils.isEmpty(this.h5Url) || TextUtils.isEmpty(this.h5Version) || TextUtils.isEmpty(this.h5Checksum)) ? false : true;
        }
    }

    /* loaded from: classes7.dex */
    public static class TemplateConfigMap extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = -6512236636350788192L;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public TemplateConfig downloadLandingPageConfig;
        public TemplateConfig downloadPopWindowConfig;
        public TemplateConfig insertScreenTemplateConfig;
        public TemplateConfig interactPageDialogTipsConfig;
        public TemplateConfig rewardReflowConfig;
        public TemplateConfig secDownloadPopWindowConfig;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.mOriginalObjData = jSONObject;
            String optString = jSONObject.optString("data");
            e.a(jSONObject.optString("egid"));
            JSONObject jSONObject2 = new JSONObject(d.b(optString));
            this.mDataJsonObj = jSONObject2;
            this.requestInterval = jSONObject2.optLong("requestInterval");
            JSONObject optJSONObject = this.mDataJsonObj.optJSONObject("abConfig");
            this.abConfig = optJSONObject;
            com.kwad.sdk.core.config.a.a(optJSONObject);
            this.appConfig = this.mDataJsonObj.optJSONObject(PrefetchEvent.EVENT_KEY_APP_CONFIG);
            this.h5PreloadConfigs = t.a(this.mDataJsonObj.optString("h5PreloadConfigs"), new com.kwad.sdk.core.c<com.kwad.sdk.c.kwai.c>() { // from class: com.kwad.sdk.core.response.model.SdkConfigData.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.c
                /* renamed from: b */
                public com.kwad.sdk.c.kwai.c a() {
                    return new com.kwad.sdk.c.kwai.c();
                }
            });
            com.kwad.sdk.core.config.a.a(this.appConfig);
            this.templateConfig.parseJson(this.mDataJsonObj.optJSONObject("templateConfig"));
            this.splashConfig.parseJson(this.mDataJsonObj.optJSONObject("splashConfig"));
            this.templateConfigMap.parseJson(this.mDataJsonObj.optJSONObject("templateConfigMap"));
            this.couponActiveConfig.parseJson(this.mDataJsonObj.optJSONObject("couponActiveConfig"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return this.mDataJsonObj;
    }
}
