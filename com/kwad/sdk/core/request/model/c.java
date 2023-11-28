package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements com.kwad.sdk.core.b {
    public static c ayB;
    public double latitude;
    public double longitude;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    public static c DS() {
        c cVar = ayB;
        if (cVar != null) {
            return cVar;
        }
        Location bV = av.bV(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
        if (bV != null) {
            c cVar2 = new c();
            ayB = cVar2;
            cVar2.latitude = bV.getLatitude();
            ayB.longitude = bV.getLongitude();
        }
        return ayB;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "latitude", this.latitude);
        t.putValue(jSONObject, "longitude", this.longitude);
        return jSONObject;
    }
}
