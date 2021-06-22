package com.kwad.sdk.core.network;

import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.g.a.m;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class d extends b {
    @Override // com.kwad.sdk.core.network.b
    public void e() {
        String a2 = a();
        if (!com.kwad.sdk.a.f32282b.booleanValue() || a2.contains(com.kwad.sdk.d.d())) {
            return;
        }
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_AD_UNIVERSE");
        if (a3 == null) {
            a("trace-context", "{\"laneId\":\"ad_test.universe\"}");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("laneId", a3.getValue().toString());
            a("trace-context", jSONObject.toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
        b("protocolVersion", "2.0");
        b("SDKVersion", "3.3.9");
        a("SDKVersionCode", 3030900);
        b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
        a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
        a("sdkType", com.kwad.sdk.d.f35260a);
        a(DI.APP_INFO_NAME, com.kwad.sdk.core.g.a.b.a());
        a("deviceInfo", com.kwad.sdk.core.g.a.d.a(g()));
        a("networkInfo", com.kwad.sdk.core.g.a.i.a());
        a("geoInfo", com.kwad.sdk.core.g.a.e.a());
        a("ext", com.kwad.sdk.core.g.a.k.a());
        a("userInfo", m.a());
        com.kwad.sdk.core.g.a.g a2 = com.kwad.sdk.core.g.a.g.a();
        if (a2 != null) {
            a("localConfig", a2);
        }
    }

    public boolean g() {
        return false;
    }
}
