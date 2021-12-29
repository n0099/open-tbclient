package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.b {
    public static e a;

    /* renamed from: b  reason: collision with root package name */
    public double f58362b;

    /* renamed from: c  reason: collision with root package name */
    public double f58363c;

    public static e a() {
        e eVar = a;
        if (eVar != null) {
            return eVar;
        }
        Location a2 = r.a(KsAdSDKImpl.get().getContext());
        if (a2 != null) {
            e eVar2 = new e();
            a = eVar2;
            eVar2.f58362b = a2.getLatitude();
            a.f58363c = a2.getLongitude();
        }
        return a;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "latitude", this.f58362b);
        t.a(jSONObject, "longitude", this.f58363c);
        return jSONObject;
    }
}
