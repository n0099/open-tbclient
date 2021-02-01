package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import org.json.JSONException;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public class SdkConfig {
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appId;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appKey;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appName;
    @Nullable
    @KsAdSdkApi
    @Keep
    public String appWebKey;
    @KsAdSdkApi
    @Keep
    private boolean canReadICCID;
    @KsAdSdkApi
    @Keep
    private boolean canReadMacAddress;
    @KsAdSdkApi
    @Keep
    private boolean canReadNearbyWifiList;
    @KsAdSdkApi
    @Keep
    public boolean enableDebug;
    @Nullable
    @KsAdSdkApi
    @Keep
    public boolean showNotification;

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public static class Builder {
        @Nullable
        private String appId;
        @Nullable
        private String appKey;
        @Nullable
        private String appName;
        @Nullable
        private String appWebKey;
        private boolean enableDebug;
        private boolean showNotification = true;
        private boolean canReadMacAddress = true;
        private boolean canReadNearbyWifiList = true;
        private boolean canReadICCID = true;

        @KsAdSdkApi
        @Keep
        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appKey(@Nullable String str) {
            this.appKey = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder appWebKey(@Nullable String str) {
            this.appWebKey = str;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public SdkConfig build() {
            return new SdkConfig(this);
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadICCID(boolean z) {
            this.canReadICCID = z;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadMacAddress(boolean z) {
            this.canReadMacAddress = z;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder canReadNearbyWifiList(boolean z) {
            this.canReadNearbyWifiList = z;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder debug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    private SdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appKey = builder.appKey;
        this.appWebKey = builder.appWebKey;
        this.showNotification = builder.showNotification;
        this.canReadMacAddress = builder.canReadMacAddress;
        this.canReadNearbyWifiList = builder.canReadNearbyWifiList;
        this.canReadICCID = builder.canReadICCID;
    }

    public static SdkConfig create(String str) {
        Builder builder = new Builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.enableDebug = jSONObject.optBoolean("enableDebug");
            builder.appId = jSONObject.optString("appId");
            builder.appName = jSONObject.optString("appName");
            builder.appKey = jSONObject.optString("appKey");
            builder.appWebKey = jSONObject.optString("appWebKey");
            builder.showNotification = jSONObject.optBoolean("showNotification");
            builder.canReadMacAddress = jSONObject.optBoolean("canReadMacAddress");
            builder.canReadNearbyWifiList = jSONObject.optBoolean("canReadNearbyWifiList");
            builder.canReadICCID = jSONObject.optBoolean("canReadICCID");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadICCID() {
        return this.canReadICCID;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadMacAddress() {
        return this.canReadMacAddress;
    }

    @KsAdSdkApi
    @Keep
    public boolean canReadNearbyWifiList() {
        return this.canReadNearbyWifiList;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableDebug", this.enableDebug);
            jSONObject.put("appId", this.appId);
            jSONObject.put("appName", this.appName);
            jSONObject.put("appKey", this.appKey);
            jSONObject.put("appWebKey", this.appWebKey);
            jSONObject.put("showNotification", this.showNotification);
            jSONObject.put("canReadMacAddress", this.canReadMacAddress);
            jSONObject.put("canReadNearbyWifiList", this.canReadNearbyWifiList);
            jSONObject.put("canReadICCID", this.canReadICCID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
