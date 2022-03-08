package com.kwad.sdk.core.video.kwai.kwai;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.request.model.e;
import com.kwad.sdk.core.request.model.h;
import com.kwad.sdk.d;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.core.network.b {
    public b(List<c> list) {
        a("actionList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return d.g();
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
    }

    @Override // com.kwad.sdk.core.network.b
    public void h() {
        b("protocolVersion", "2.0");
        b("SDKVersion", "3.3.17.4");
        a("SDKVersionCode", 3031704);
        b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
        a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
        a("sdkType", 1);
        a(DI.APP_INFO_NAME, com.kwad.sdk.core.request.model.b.a());
        a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.d.a(false));
        a("networkInfo", h.a());
        a("geoInfo", e.a());
    }
}
