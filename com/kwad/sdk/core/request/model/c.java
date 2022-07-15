package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c implements com.kwad.sdk.core.b {
    public static c a;
    public double b;
    public double c;

    public static c a() {
        c cVar = a;
        if (cVar != null) {
            return cVar;
        }
        Location l = ao.l(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a());
        if (l != null) {
            c cVar2 = new c();
            a = cVar2;
            cVar2.b = l.getLatitude();
            a.c = l.getLongitude();
        }
        return a;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "latitude", this.b);
        r.a(jSONObject, "longitude", this.c);
        return jSONObject;
    }
}
