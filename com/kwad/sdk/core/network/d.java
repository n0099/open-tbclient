package com.kwad.sdk.core.network;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";
    public static int sLiveSupportMode;

    public boolean needAppList() {
        return false;
    }

    public d() {
        this(0, null);
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        }
    }

    public d(int i, @Nullable SceneImpl sceneImpl) {
        putBody(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.b.h(needAppList(), i));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.b(sceneImpl));
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
        putBody("sdkType", 1);
        putBody(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.a.DP());
        putBody("tkVersion", "5.1.4");
        putBody("adSdkVersion", BuildConfig.VERSION_NAME);
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.DT());
        if (sLiveSupportMode == 0 && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).oA()) {
            sLiveSupportMode = 1;
        }
        Log.d("CommonBaseRequest", "sLiveSupportMode :" + sLiveSupportMode);
        putBody("liveSupportMode", sLiveSupportMode);
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.DS());
        putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yi());
        putBody("ext", com.kwad.sdk.core.request.model.e.DV());
        putBody("userInfo", com.kwad.sdk.core.request.model.g.DW());
        putBody("requestSessionData", q.CF().dp(getUrl()));
        putBody("timestamp", System.currentTimeMillis());
    }
}
