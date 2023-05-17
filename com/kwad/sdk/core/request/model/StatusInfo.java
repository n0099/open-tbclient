package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;
import java.util.List;
@KsJson
/* loaded from: classes9.dex */
public class StatusInfo extends com.kwad.sdk.core.response.kwai.a {
    public SplashAdInfo acU;
    public int acS = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).isPersonalRecommend() ? 1 : 0;
    public int acT = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).isProgrammaticRecommend() ? 1 : 0;
    public List<f> acV = com.kwad.sdk.core.d.a.ts();

    @KsJson
    /* loaded from: classes9.dex */
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.b.yU();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.b.d(sceneImpl);
            return splashAdInfo;
        }
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    public StatusInfo(SceneImpl sceneImpl) {
        this.acU = SplashAdInfo.create(sceneImpl);
    }

    public static StatusInfo a(long j, SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
