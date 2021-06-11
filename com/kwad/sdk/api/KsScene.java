package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes6.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes6.dex */
    public static class Builder {
        public KsScene scene;

        @KsAdSdkApi
        @Keep
        public Builder(long j) {
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j);
        }

        @KsAdSdkApi
        @Keep
        public Builder action(int i2) {
            this.scene.setAction(i2);
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
        public Builder adStyle(int i2) {
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
        public Builder posId(long j) {
            this.scene.setPosId(j);
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
    int getHeight();

    @KsAdSdkApi
    @Keep
    long getPosId();

    @KsAdSdkApi
    @Keep
    int getWidth();

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
    void setHeight(int i2);

    @KsAdSdkApi
    @Keep
    void setPosId(long j);

    @KsAdSdkApi
    @Keep
    void setWidth(int i2);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
