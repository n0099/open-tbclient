package com.kwad.sdk.core.network;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes7.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public d() {
        this(0L, 0, null);
    }

    public d(long j, int i, SceneImpl sceneImpl) {
        putBody(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.b.f(isAddAppPackageNameParam(), i));
        putBody("statusInfo", StatusInfo.a(j, sceneImpl));
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersionCode());
        putBody("sdkType", 1);
        putBody(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.a.uM());
        putBody("tkVersion", "4.0.2");
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.uQ());
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.uP());
        putBody("ext", com.kwad.sdk.core.request.model.e.uS());
        putBody("userInfo", com.kwad.sdk.core.request.model.g.uT());
        putBody("requestSessionData", p.tE().bW(getUrl()));
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        String url = getUrl();
        if (!com.kwad.b.kwai.a.aw.booleanValue() || url == null || url.contains(com.kwad.sdk.b.qO())) {
            return;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
    }

    public boolean isAddAppPackageNameParam() {
        return false;
    }
}
