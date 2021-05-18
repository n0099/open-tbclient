package com.kwad.sdk.core.network;

import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public int f32465b = 0;

    public d() {
        a(0);
    }

    public void a(int i2) {
        this.f32465b = i2;
        a("deviceInfo", com.kwad.sdk.core.g.a.d.a(g(), i2));
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
        String a2 = a();
        if (!com.kwad.sdk.b.f31890b.booleanValue() || a2.contains(com.kwad.sdk.d.c())) {
            return;
        }
        DevelopMangerPlugin.DevelopValue a3 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_AD_UNIVERSE");
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
        b("SDKVersion", "3.3.8.3");
        a("SDKVersionCode", 3030803);
        b("sdkApiVersion", KsAdSDKImpl.get().getApiVersion());
        a("sdkApiVersionCode", KsAdSDKImpl.get().getApiVersionCode());
        a("sdkType", com.kwad.sdk.d.f33109a);
        a(DI.APP_INFO_NAME, com.kwad.sdk.core.g.a.b.a());
        a("deviceInfo", com.kwad.sdk.core.g.a.d.a(g()));
        a("networkInfo", com.kwad.sdk.core.g.a.i.a());
        a("geoInfo", com.kwad.sdk.core.g.a.e.a());
        a("ext", com.kwad.sdk.core.g.a.j.a());
        a("userInfo", com.kwad.sdk.core.g.a.l.a());
        com.kwad.sdk.core.g.a.g a2 = com.kwad.sdk.core.g.a.g.a();
        if (a2 != null) {
            a("localConfig", a2);
        }
    }

    public boolean g() {
        return false;
    }
}
