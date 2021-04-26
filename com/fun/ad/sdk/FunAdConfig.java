package com.fun.ad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public final class FunAdConfig {
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public final Context appContext;
    public final String appId;
    public final String appName;
    public final boolean isFilterDeepLinkAd;
    public final boolean isUseCloudAdConfiguration;
    public final boolean isUseTextureView;
    public final boolean isVideoDataFlowAutoStart;
    public final boolean isVideoSoundEnable;
    public final boolean logEnabled;
    public final int titleBarTheme;
    public final String userId;

    /* loaded from: classes6.dex */
    public static class Builder {
        public Context appContext;
        public String appId;
        public String appName;
        public String userId;
        public boolean useTextureView = false;
        public int titleBarTheme = -1;
        public boolean videoSoundEnable = false;
        public boolean videoDataFlowAutoStart = false;
        public boolean logEnabled = false;
        public boolean useCloudAdConfiguration = true;
        public boolean filterDeepLinkAd = false;

        public Builder(@NonNull Context context) {
            this.appContext = context.getApplicationContext();
        }

        public FunAdConfig build() {
            return new FunAdConfig(this);
        }

        public Builder setAppId(@NonNull String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppName(@NonNull String str) {
            this.appName = str;
            return this;
        }

        public Builder setFilterDeepLinkAd(boolean z) {
            this.filterDeepLinkAd = z;
            return this;
        }

        public Builder setLogEnabled(boolean z) {
            this.logEnabled = z;
            return this;
        }

        public Builder setTitleBarTheme(int i2) {
            this.titleBarTheme = i2;
            return this;
        }

        public Builder setUseCloudAdConfiguration(boolean z) {
            this.useCloudAdConfiguration = z;
            return this;
        }

        public Builder setUseTextureView(boolean z) {
            this.useTextureView = z;
            return this;
        }

        public Builder setUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder setVideoDataFlowAutoStart(boolean z) {
            this.videoDataFlowAutoStart = z;
            return this;
        }

        public Builder setVideoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    public FunAdConfig(Builder builder) {
        this.appContext = builder.appContext;
        this.appName = builder.appName;
        this.appId = builder.appId;
        this.isUseTextureView = builder.useTextureView;
        this.titleBarTheme = builder.titleBarTheme;
        this.isVideoSoundEnable = builder.videoSoundEnable;
        this.isVideoDataFlowAutoStart = builder.videoDataFlowAutoStart;
        this.logEnabled = builder.logEnabled;
        this.isUseCloudAdConfiguration = builder.useCloudAdConfiguration;
        this.isFilterDeepLinkAd = builder.filterDeepLinkAd;
        this.userId = builder.userId;
    }
}
