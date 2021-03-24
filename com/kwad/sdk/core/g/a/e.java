package com.kwad.sdk.core.g.a;

import android.location.Location;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.export.proxy.AdLocationProxy;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public double f33648a;

    /* renamed from: b  reason: collision with root package name */
    public double f33649b;

    public static e a() {
        double longitude;
        e eVar = new e();
        AdLocationProxy proxyForAdLocation = KsAdSDKImpl.get().getProxyForAdLocation();
        if (proxyForAdLocation == null) {
            Location a2 = com.kwad.sdk.utils.l.a(KsAdSDKImpl.get().getContext());
            if (a2 != null) {
                eVar.f33648a = a2.getLatitude();
                longitude = a2.getLongitude();
            }
            return eVar;
        }
        eVar.f33648a = proxyForAdLocation.getLatitude();
        longitude = proxyForAdLocation.getLongitude();
        eVar.f33649b = longitude;
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "latitude", this.f33648a);
        o.a(jSONObject, "longitude", this.f33649b);
        return jSONObject;
    }
}
