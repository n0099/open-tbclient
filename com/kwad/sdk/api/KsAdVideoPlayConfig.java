package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
@KsAdSdkApi
@Keep
/* loaded from: classes6.dex */
public interface KsAdVideoPlayConfig {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes6.dex */
    public static class Builder {
        public boolean dataFlowAutoStart;
        public boolean videoSoundEnable;

        @KsAdSdkApi
        @Keep
        public KsAdVideoPlayConfig build() {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = (KsAdVideoPlayConfig) Loader.get().newInstance(KsAdVideoPlayConfig.class);
            ksAdVideoPlayConfig.setVideoSoundEnable(this.videoSoundEnable);
            ksAdVideoPlayConfig.setDataFlowAutoStart(this.dataFlowAutoStart);
            return ksAdVideoPlayConfig;
        }

        @KsAdSdkApi
        @Keep
        public Builder dataFlowAutoStart(boolean z) {
            this.dataFlowAutoStart = z;
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder videoSoundEnable(boolean z) {
            this.videoSoundEnable = z;
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    boolean isDataFlowAutoStart();

    @KsAdSdkApi
    @Keep
    boolean isVideoSoundEnable();

    @KsAdSdkApi
    @Keep
    void setDataFlowAutoStart(boolean z);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z);
}
