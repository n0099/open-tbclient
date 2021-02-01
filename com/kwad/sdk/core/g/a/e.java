package com.kwad.sdk.core.g.a;

import android.location.Location;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private double f9165a;

    /* renamed from: b  reason: collision with root package name */
    private double f9166b;

    public static e a() {
        e eVar = new e();
        AdLocationProxy proxyForAdLocation = KsAdSDKImpl.get().getProxyForAdLocation();
        if (proxyForAdLocation != null) {
            eVar.f9165a = proxyForAdLocation.getLatitude();
            eVar.f9166b = proxyForAdLocation.getLongitude();
        } else {
            Location a2 = com.kwad.sdk.utils.l.a(KsAdSDKImpl.get().getContext());
            if (a2 != null) {
                eVar.f9165a = a2.getLatitude();
                eVar.f9166b = a2.getLongitude();
            }
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "latitude", this.f9165a);
        o.a(jSONObject, "longitude", this.f9166b);
        return jSONObject;
    }
}
