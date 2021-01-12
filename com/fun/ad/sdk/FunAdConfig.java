package com.fun.ad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes14.dex */
public final class FunAdConfig {
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public long adExpiredTimeInterval;
    public Context appContext;
    public String appId;
    public String appName;
    public boolean asyncInit;
    public boolean filterDeepLinkAd;
    public boolean filterDuplicatedAd;
    public boolean logEnabled;
    public boolean reportAdMaterials;
    public boolean supportMultiProcess;
    public int titleBarTheme;
    public boolean useCloudAdConfiguration;
    public boolean useTextureView;
    public boolean videoDataFlowAutoStart;
    public boolean videoSoundEnable;

    /* loaded from: classes14.dex */
    public static class Builder {
        public static final long AD_EXPIRED_INTERVAL = 900000;
        public Context appContext;
        public String appId;
        public String appName;
        public boolean reportAdMaterials = false;
        public boolean useTextureView = false;
        public int titleBarTheme = -1;
        public boolean supportMultiProcess = false;
        public boolean asyncInit = false;
        public boolean videoSoundEnable = false;
        public boolean videoDataFlowAutoStart = false;
        public boolean logEnabled = false;
        public boolean useCloudAdConfiguration = true;
        public boolean filterDuplicatedAd = false;
        public boolean filterDeepLinkAd = false;
        public long adExpiredTimeInterval = AD_EXPIRED_INTERVAL;

        public Builder(@NonNull Context context) {
            this.appContext = context.getApplicationContext();
        }

        public FunAdConfig build() {
            return new FunAdConfig(this);
        }

        public Builder setAdExpiredTimeInterval(long j) {
            this.adExpiredTimeInterval = j;
            return this;
        }

        public Builder setAppId(@NonNull String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppName(@NonNull String str) {
            this.appName = str;
            return this;
        }

        public Builder setAsyncInit(boolean z) {
            this.asyncInit = z;
            return this;
        }

        public Builder setFilterDeepLinkAd(boolean z) {
            this.filterDeepLinkAd = z;
            return this;
        }

        public Builder setFilterDuplicatedAd(boolean z) {
            this.filterDuplicatedAd = z;
            return this;
        }

        public Builder setLogEnabled(boolean z) {
            this.logEnabled = z;
            return this;
        }

        public Builder setReportAdMaterials(boolean z) {
            this.reportAdMaterials = z;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }

        public Builder setTitleBarTheme(int i) {
            this.titleBarTheme = i;
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

        public Builder setVideoDataFlowAutoStart(boolean z) {
            this.videoDataFlowAutoStart = z;
            return this;
        }

        public Builder setVideoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    public FunAdConfig() {
        this.reportAdMaterials = false;
        this.useTextureView = false;
        this.titleBarTheme = -1;
        this.supportMultiProcess = false;
        this.asyncInit = false;
        this.videoSoundEnable = false;
        this.videoDataFlowAutoStart = false;
        this.logEnabled = false;
        this.useCloudAdConfiguration = true;
        this.filterDuplicatedAd = false;
        this.filterDeepLinkAd = false;
    }

    public FunAdConfig(Builder builder) {
        this.reportAdMaterials = false;
        this.useTextureView = false;
        this.titleBarTheme = -1;
        this.supportMultiProcess = false;
        this.asyncInit = false;
        this.videoSoundEnable = false;
        this.videoDataFlowAutoStart = false;
        this.logEnabled = false;
        this.useCloudAdConfiguration = true;
        this.filterDuplicatedAd = false;
        this.filterDeepLinkAd = false;
        this.appContext = builder.appContext;
        this.appName = builder.appName;
        this.appId = builder.appId;
        this.reportAdMaterials = builder.reportAdMaterials;
        this.useTextureView = builder.useTextureView;
        this.titleBarTheme = builder.titleBarTheme;
        this.supportMultiProcess = builder.supportMultiProcess;
        this.asyncInit = builder.asyncInit;
        this.videoSoundEnable = builder.videoSoundEnable;
        this.videoDataFlowAutoStart = builder.videoDataFlowAutoStart;
        this.logEnabled = builder.logEnabled;
        this.useCloudAdConfiguration = builder.useCloudAdConfiguration;
        this.filterDuplicatedAd = builder.filterDuplicatedAd;
        this.filterDeepLinkAd = builder.filterDeepLinkAd;
        this.adExpiredTimeInterval = builder.adExpiredTimeInterval;
    }

    public long getAdExpiredTimeInterval() {
        return this.adExpiredTimeInterval;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getTitleBarTheme() {
        return this.titleBarTheme;
    }

    public boolean isAsyncInit() {
        return this.asyncInit;
    }

    public boolean isFilterDeepLinkAd() {
        return this.filterDeepLinkAd;
    }

    public boolean isFilterDuplicatedAd() {
        return this.filterDuplicatedAd;
    }

    public boolean isLogEnabled() {
        return this.logEnabled;
    }

    public boolean isReportAdMaterials() {
        return this.reportAdMaterials;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    public boolean isUseCloudAdConfiguration() {
        return this.useCloudAdConfiguration;
    }

    public boolean isUseTextureView() {
        return this.useTextureView;
    }

    public boolean isVideoDataFlowAutoStart() {
        return this.videoDataFlowAutoStart;
    }

    public boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }
}
