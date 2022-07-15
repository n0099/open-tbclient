package com.kwad.sdk.core.network;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes5.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public d() {
        this(0L, 0, null);
    }

    public d(long j, int i, SceneImpl sceneImpl) {
        putBody(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.b.a(isAddAppPackageNameParam(), i));
        putBody("statusInfo", StatusInfo.a(j, sceneImpl));
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).e());
        putBody("sdkApiVersionCode", ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).f());
        putBody("sdkType", 1);
        putBody(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.a.a());
        putBody("tkVersion", "4.0.0");
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.a());
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.a());
        putBody("ext", com.kwad.sdk.core.request.model.e.a());
        putBody("userInfo", com.kwad.sdk.core.request.model.g.a());
        putBody("requestSessionData", o.a().a(getUrl()));
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        String url = getUrl();
        if (!com.kwad.b.kwai.a.b.booleanValue() || url == null || url.contains(com.kwad.sdk.b.f())) {
            return;
        }
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
    }

    public boolean isAddAppPackageNameParam() {
        return false;
    }
}
