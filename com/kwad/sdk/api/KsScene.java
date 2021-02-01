package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import java.io.Serializable;
import org.json.JSONObject;
@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public static class Builder {
        private KsScene scene = (KsScene) Loader.get().newInstance(KsScene.class);

        @KsAdSdkApi
        @Keep
        public Builder(long j) {
            this.scene.setPosId(j);
        }

        @KsAdSdkApi
        @Keep
        public Builder action(int i) {
            this.scene.setAction(i);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adNum(int i) {
            this.scene.setAdNum(i);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adStyle(int i) {
            this.scene.setAdNum(i);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public KsScene build() {
            return this.scene;
        }

        @KsAdSdkApi
        @Keep
        public Builder height(int i) {
            this.scene.setHeight(i);
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
        public Builder width(int i) {
            this.scene.setWidth(i);
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
    void setAction(int i);

    @KsAdSdkApi
    @Keep
    void setAdNum(int i);

    @KsAdSdkApi
    @Keep
    void setAdStyle(int i);

    @KsAdSdkApi
    @Keep
    void setHeight(int i);

    @KsAdSdkApi
    @Keep
    void setPosId(long j);

    @KsAdSdkApi
    @Keep
    void setWidth(int i);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
