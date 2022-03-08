package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsAdVideoPlayConfig {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static class Builder {
        public boolean dataFlowAutoStart;
        public boolean videoSoundEnable;
        public boolean isNoCache = false;
        public KsAdVideoPlayConfig config = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);

        @KsAdSdkApi
        @Keep
        public KsAdVideoPlayConfig build() {
            return this.config;
        }

        @KsAdSdkApi
        @Keep
        public Builder dataFlowAutoStart(boolean z) {
            this.config.setDataFlowAutoStart(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder noCache() {
            this.config.setNoCache();
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z) {
            this.config.setVideoSoundEnable(z);
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    @Keep
    boolean isNoCache();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setDataFlowAutoStart(boolean z);

    @KsAdSdkApi
    @Keep
    void setNoCache();

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z);
}
