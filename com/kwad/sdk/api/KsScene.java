package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.b;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public static class Builder {
        public KsScene scene;

        @KsAdSdkApi
        @Keep
        public Builder(long j2) {
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j2);
        }

        @KsAdSdkApi
        @Keep
        public Builder action(int i2) {
            this.scene.setAction(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adLabel(b bVar) {
            this.scene.setKsAdLabel(bVar);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adNum(int i2) {
            this.scene.setAdNum(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public KsScene build() {
            return this.scene;
        }

        @KsAdSdkApi
        @Keep
        public Builder height(int i2) {
            this.scene.setHeight(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder needShowMiniWindow(boolean z) {
            this.scene.needShowMiniWindow(z);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder posId(long j2) {
            this.scene.setPosId(j2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder promoteId(String str) {
            this.scene.setPromoteId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            this.scene.setRewardCallbackExtraData(map);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder screenOrientation(int i2) {
            this.scene.setScreenOrientation(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBackUrl(String str) {
            this.scene.setBackUrl(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setComment(String str) {
            this.scene.setComment(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateBuying(int i2) {
            this.scene.setUserCommRateBuying(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateSharing(int i2) {
            this.scene.setUserCommRateSharing(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder width(int i2) {
            this.scene.setWidth(i2);
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    int getAction();

    @KsAdSdkApi
    @Keep
    int getAdNum();

    @KsAdSdkApi
    @Keep
    int getAdStyle();

    @KsAdSdkApi
    @Keep
    String getBackUrl();

    @KsAdSdkApi
    @Keep
    String getComment();

    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    long getPosId();

    @KsAdSdkApi
    @Keep
    String getPromoteId();

    @KsAdSdkApi
    @Keep
    Map<String, String> getRewardCallbackExtraData();

    @KsAdSdkApi
    @Keep
    int getScreenOrientation();

    @KsAdSdkApi
    @Keep
    long getUserCommRateBuying();

    @KsAdSdkApi
    @Keep
    long getUserCommRateSharing();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    void needShowMiniWindow(boolean z);

    @KsAdSdkApi
    @Keep
    void setAction(int i2);

    @KsAdSdkApi
    @Keep
    void setAdNum(int i2);

    @KsAdSdkApi
    @Keep
    void setAdStyle(int i2);

    @KsAdSdkApi
    @Keep
    void setBackUrl(String str);

    @KsAdSdkApi
    @Keep
    void setComment(String str);

    @KsAdSdkApi
    @Keep
    void setHeight(int i2);

    @KsAdSdkApi
    @Keep
    void setKsAdLabel(com.kwad.sdk.api.model.a aVar);

    @KsAdSdkApi
    @Keep
    void setPosId(long j2);

    @KsAdSdkApi
    @Keep
    void setPromoteId(String str);

    @KsAdSdkApi
    @Keep
    void setRewardCallbackExtraData(Map<String, String> map);

    @KsAdSdkApi
    @Keep
    void setScreenOrientation(int i2);

    @KsAdSdkApi
    @Keep
    void setUserCommRateBuying(int i2);

    @KsAdSdkApi
    @Keep
    void setUserCommRateSharing(int i2);

    @KsAdSdkApi
    @Keep
    void setWidth(int i2);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
