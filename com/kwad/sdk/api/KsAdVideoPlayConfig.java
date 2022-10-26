package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsAdVideoPlayConfig {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public class Builder {
        public boolean dataFlowAutoStart;
        public boolean videoSoundEnable;
        public boolean isNoCache = false;
        public KsAdVideoPlayConfig config = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);

        @KsAdSdkApi
        public KsAdVideoPlayConfig build() {
            return this.config;
        }

        @KsAdSdkApi
        @Deprecated
        public Builder dataFlowAutoStart(boolean z) {
            this.config.setDataFlowAutoStart(z);
            return this;
        }

        @KsAdSdkApi
        public Builder noCache() {
            this.config.setNoCache();
            return this;
        }

        @KsAdSdkApi
        public Builder videoAutoPlayType(int i) {
            this.config.setVideoAutoPlayType(i);
            return this;
        }

        @KsAdSdkApi
        public Builder videoSoundEnable(boolean z) {
            this.config.setVideoSoundEnable(z);
            return this;
        }
    }

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public @interface VideoAutoPlayType {
        public static final int AUTO_PLAY = 1;
        public static final int AUTO_PLAY_WIFI = 2;
        public static final int NO_AUTO_PLAY = 3;
        public static final int UNKNOWN = 0;
    }

    @KsAdSdkApi
    int getVideoAutoPlayType();

    @KsAdSdkApi
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    boolean isNoCache();

    @KsAdSdkApi
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Deprecated
    void setDataFlowAutoStart(boolean z);

    @KsAdSdkApi
    void setNoCache();

    @KsAdSdkApi
    void setVideoAutoPlayType(int i);

    @KsAdSdkApi
    void setVideoSoundEnable(boolean z);
}
