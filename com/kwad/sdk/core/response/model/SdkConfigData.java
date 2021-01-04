package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    public static final int DEFAULT_SPLASH_TIME_OUT = 5000;
    private static final long serialVersionUID = -7796837168148055391L;
    private JSONObject abConfig;
    public long requestInterval = 3600;
    public TemplateConfig templateConfig = new TemplateConfig();
    public TemplateConfig splashConfig = new TemplateConfig();
    public TemplateConfig rewardMiniCardConfig = new TemplateConfig();
    public TemplateConfig rewardMiddleEndcardConfig = new TemplateConfig();
    public TemplateConfigMap templateConfigMap = new TemplateConfigMap();

    /* loaded from: classes5.dex */
    public static class TemplateConfig extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6943205584670122269L;
        public String h5Checksum;
        public String h5Url;
        public String h5Version;
    }

    /* loaded from: classes5.dex */
    public static class TemplateConfigMap extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6512236636350788192L;
        public TemplateConfig downloadPopWindowConfig;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("data");
            e.a(jSONObject.optString("egid"));
            JSONObject jSONObject2 = new JSONObject(d.b(optString));
            this.requestInterval = jSONObject2.optLong("requestInterval");
            this.abConfig = jSONObject2.optJSONObject("abConfig");
            com.kwad.sdk.core.config.b.a(this.abConfig);
            this.templateConfig.parseJson(jSONObject2.optJSONObject("templateConfig"));
            this.splashConfig.parseJson(jSONObject2.optJSONObject("splashConfig"));
            this.rewardMiniCardConfig.parseJson(jSONObject2.optJSONObject("rewardMiniCardConfig"));
            this.rewardMiddleEndcardConfig.parseJson(jSONObject2.optJSONObject("rewardMiddleEndcardConfig"));
            this.templateConfigMap.parseJson(jSONObject2.optJSONObject("templateConfigMap"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "requestInterval", this.requestInterval);
        o.a(json, "abConfig", this.abConfig);
        o.a(json, "templateConfig", this.templateConfig);
        o.a(json, "splashConfig", this.splashConfig);
        o.a(json, "rewardMiniCardConfig", this.rewardMiniCardConfig);
        o.a(json, "rewardMiddleEndcardConfig", this.rewardMiddleEndcardConfig);
        o.a(json, "templateConfigMap", this.templateConfigMap);
        return json;
    }
}
