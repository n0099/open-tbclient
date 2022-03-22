package com.kwad.sdk.core.network;

import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.live.interfaces.DI;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class d extends b {
    public d() {
        this(0);
    }

    public d(int i) {
        a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, com.kwad.sdk.core.request.model.d.a(j(), i));
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
        String a = a();
        if (!com.kwad.sdk.b.f39154c.booleanValue() || a == null || a.contains(com.kwad.sdk.d.d())) {
            return;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_AD_UNIVERSE");
        if (a2 == null) {
            a("trace-context", "{\"laneId\":\"ad_test.universe\"}");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("laneId", a2.getValue().toString());
            a("trace-context", jSONObject.toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
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
        a("networkInfo", com.kwad.sdk.core.request.model.h.a());
        a("geoInfo", com.kwad.sdk.core.request.model.e.a());
        a("ext", com.kwad.sdk.core.request.model.i.a());
        a("userInfo", com.kwad.sdk.core.request.model.l.a());
        a("statusInfo", i());
        b("requestSessionData", l.a().a(a()));
    }

    public com.kwad.sdk.core.request.model.j i() {
        return new com.kwad.sdk.core.request.model.j();
    }

    public boolean j() {
        return false;
    }
}
