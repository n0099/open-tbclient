package com.kwad.sdk.core.request.model;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class d implements com.kwad.sdk.core.b {
    public String acO;
    public int acP;
    public int acQ;

    public static d uQ() {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        d dVar = new d();
        dVar.acO = ar.cK(context);
        dVar.acP = ae.cw(context);
        dVar.acQ = ae.T(context, ar.cN(context));
        return dVar;
    }

    public static d uR() {
        d dVar = new d();
        dVar.acP = ae.cw(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext());
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "mac", this.acO);
        r.putValue(jSONObject, "connectionType", this.acP);
        r.putValue(jSONObject, "operatorType", this.acQ);
        return jSONObject;
    }
}
