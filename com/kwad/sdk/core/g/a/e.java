package com.kwad.sdk.core.g.a;

import android.location.Location;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public double f33066a;

    /* renamed from: b  reason: collision with root package name */
    public double f33067b;

    public static e a() {
        e eVar = new e();
        Location a2 = m.a(KsAdSDKImpl.get().getContext());
        if (a2 != null) {
            eVar.f33066a = a2.getLatitude();
            eVar.f33067b = a2.getLongitude();
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "latitude", this.f33066a);
        o.a(jSONObject, "longitude", this.f33067b);
        return jSONObject;
    }
}
