package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class StatusInfo extends com.kwad.sdk.core.response.a.a {
    public SplashAdInfo ayJ;
    public NativeAdRequestInfo ayK;
    public int ayH = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).isPersonalRecommend() ? 1 : 0;
    public int ayI = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).isProgrammaticRecommend() ? 1 : 0;
    public List<f> ayL = com.kwad.sdk.core.d.a.Cx();

    @KsJson
    /* loaded from: classes10.dex */
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    public StatusInfo(SceneImpl sceneImpl) {
        this.ayK = NativeAdRequestInfo.create(sceneImpl);
        this.ayJ = SplashAdInfo.create(sceneImpl);
    }

    public static StatusInfo b(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.b.d(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            t.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.b.Jp();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.b.c(sceneImpl);
            return splashAdInfo;
        }
    }
}
