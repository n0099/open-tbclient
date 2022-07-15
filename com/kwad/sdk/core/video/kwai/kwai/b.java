package com.kwad.sdk.core.video.kwai.kwai;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import java.util.List;
/* loaded from: classes5.dex */
public final class b extends com.kwad.sdk.core.network.b {
    public b(List<c> list) {
        putBody("actionList", list);
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((d) ServiceProvider.a(d.class)).e());
        putBody("sdkApiVersionCode", ((d) ServiceProvider.a(d.class)).f());
        putBody("sdkType", 1);
        putBody(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.a.a());
        putBody(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.b.a(false));
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.a());
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.a());
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.b.i();
    }
}
