package com.kwad.sdk.api;

import com.baidu.sapi2.activity.BaseActivity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import org.json.JSONException;
import org.json.JSONObject;
@KsAdSdkApi
/* loaded from: classes7.dex */
public class SdkConfig {
    public static final String DEF_NIGHT_THEME_STYLE_FILE_NAME = "ks_adsdk_night_styles.xml";
    @KsAdSdkApi
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 2;
    @KsAdSdkApi
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    @KsAdSdkApi
    public static final int SCREEN_ORIENTATION_UNKNOWN = 0;
    @KsAdSdkApi
    public String appId;
    @KsAdSdkApi
    public String appKey;
    @KsAdSdkApi
    public String appName;
    @KsAdSdkApi
    public String appWebKey;
    @KsAdSdkApi
    public boolean canReadICCID;
    @KsAdSdkApi
    public boolean canReadMacAddress;
    @KsAdSdkApi
    public boolean canReadNearbyWifiList;
    @KsAdSdkApi
    public boolean enableDebug;
    @KsAdSdkApi
    public KsCustomController ksCustomController;
    public KsInitCallback ksInitCallback;
    @KsAdSdkApi
    public String nightThemeStyleAssetsFileName;
    @KsAdSdkApi
    public boolean showNotification;

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public class Builder {
        public String appId;
        public String appKey;
        public String appName;
        public String appWebKey;
        public boolean enableDebug;
        public KsCustomController ksCustomController;
        public KsInitCallback ksInitCallback;
        public boolean showNotification = true;
        public boolean canReadMacAddress = true;
        public boolean canReadNearbyWifiList = true;
        public boolean canReadICCID = true;
        public String nightThemeStyleAssetsFileName = SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME;

        @KsAdSdkApi
        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        @KsAdSdkApi
        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        @KsAdSdkApi
        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @KsAdSdkApi
        public Builder appWebKey(String str) {
            this.appWebKey = str;
            return this;
        }

        @KsAdSdkApi
        public SdkConfig build() {
            return new SdkConfig(this);
        }

        @KsAdSdkApi
        @Deprecated
        public Builder canReadICCID(boolean z) {
            this.canReadICCID = z;
            return this;
        }

        @KsAdSdkApi
        @Deprecated
        public Builder canReadMacAddress(boolean z) {
            this.canReadMacAddress = z;
            return this;
        }

        @KsAdSdkApi
        public Builder canReadNearbyWifiList(boolean z) {
            this.canReadNearbyWifiList = z;
            return this;
        }

        @KsAdSdkApi
        public Builder customController(KsCustomController ksCustomController) {
            this.ksCustomController = ksCustomController;
            return this;
        }

        @KsAdSdkApi
        public Builder debug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        @KsAdSdkApi
        public Builder nightThemeStyleAssetsFileName(String str) {
            this.nightThemeStyleAssetsFileName = str;
            return this;
        }

        @KsAdSdkApi
        public Builder setInitCallback(KsInitCallback ksInitCallback) {
            this.ksInitCallback = ksInitCallback;
            return this;
        }

        @KsAdSdkApi
        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }
    }

    @KsAdSdkApi
    public SdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appKey = builder.appKey;
        this.appWebKey = builder.appWebKey;
        this.showNotification = builder.showNotification;
        this.canReadMacAddress = builder.canReadMacAddress;
        this.canReadNearbyWifiList = builder.canReadNearbyWifiList;
        this.canReadICCID = builder.canReadICCID;
        this.nightThemeStyleAssetsFileName = builder.nightThemeStyleAssetsFileName;
        this.ksCustomController = builder.ksCustomController;
        this.ksInitCallback = builder.ksInitCallback;
    }

    public static SdkConfig create(String str) {
        Builder builder = new Builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.enableDebug = jSONObject.optBoolean("enableDebug");
            builder.appId = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            builder.appName = jSONObject.optString("appName");
            builder.appKey = jSONObject.optString("appKey");
            builder.appWebKey = jSONObject.optString("appWebKey");
            builder.showNotification = jSONObject.optBoolean("showNotification");
            builder.canReadMacAddress = jSONObject.optBoolean("canReadMacAddress");
            builder.canReadNearbyWifiList = jSONObject.optBoolean("canReadNearbyWifiList");
            builder.canReadICCID = jSONObject.optBoolean("canReadICCID");
            builder.nightThemeStyleAssetsFileName = jSONObject.optString("nightThemeStyleAssetsFileName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    @KsAdSdkApi
    public boolean canReadICCID() {
        return this.canReadICCID;
    }

    @KsAdSdkApi
    public boolean canReadMacAddress() {
        return this.canReadMacAddress;
    }

    @KsAdSdkApi
    public boolean canReadNearbyWifiList() {
        return this.canReadNearbyWifiList;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableDebug", this.enableDebug);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
            jSONObject.put("appName", this.appName);
            jSONObject.put("appKey", this.appKey);
            jSONObject.put("appWebKey", this.appWebKey);
            jSONObject.put("showNotification", this.showNotification);
            jSONObject.put("canReadMacAddress", this.canReadMacAddress);
            jSONObject.put("canReadNearbyWifiList", this.canReadNearbyWifiList);
            jSONObject.put("canReadICCID", this.canReadICCID);
            jSONObject.put("nightThemeStyleAssetsFileName", this.nightThemeStyleAssetsFileName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
