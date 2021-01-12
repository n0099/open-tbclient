package com.kwad.sdk.core.video.a.a;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.g.a.e;
import com.kwad.sdk.core.g.a.i;
import com.kwad.sdk.d;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.network.b {
    public b(List<c> list) {
        a("actionList", list);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return d.j();
    }

    @Override // com.kwad.sdk.core.network.b
    protected void e() {
    }

    @Override // com.kwad.sdk.core.network.b
    protected void f() {
        b("protocolVersion", "2.0");
        b("SDKVersion", "3.3.9");
        a("SDKVersionCode", 3030900);
        b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
        a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
        a("sdkType", d.f9669a);
        a("appInfo", com.kwad.sdk.core.g.a.b.a());
        a("deviceInfo", com.kwad.sdk.core.g.a.d.a(false));
        a("networkInfo", i.a());
        a("geoInfo", e.a());
    }
}
