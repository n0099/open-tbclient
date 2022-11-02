package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c implements com.kwad.sdk.core.b {
    public static c acL;
    public double acM;
    public double acN;

    public static c uP() {
        c cVar = acL;
        if (cVar != null) {
            return cVar;
        }
        Location cg = ar.cg(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext());
        if (cg != null) {
            c cVar2 = new c();
            acL = cVar2;
            cVar2.acM = cg.getLatitude();
            acL.acN = cg.getLongitude();
        }
        return acL;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "latitude", this.acM);
        r.putValue(jSONObject, "longitude", this.acN);
        return jSONObject;
    }
}
