package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.av;
@KsJson
/* loaded from: classes10.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String ayC;
    public String ayD;
    public int ayE;
    public int ayF;

    public static d DT() {
        Context Jn = ServiceProvider.Jn();
        d dVar = new d();
        dVar.ayC = av.cx(Jn);
        dVar.ayD = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yh();
        dVar.ayE = ag.ck(Jn);
        dVar.ayF = ag.d(Jn, av.cA(Jn), au.KO());
        return dVar;
    }

    public static d DU() {
        d dVar = new d();
        dVar.ayE = ag.ck(ServiceProvider.getContext());
        return dVar;
    }
}
