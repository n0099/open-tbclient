package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes10.dex */
public class k extends com.kwad.sdk.core.response.a.a {
    public int avD;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public final String DB() {
        return toJson().toString();
    }

    public static k bV(AdTemplate adTemplate) {
        int i;
        k kVar = new k();
        kVar.creativeId = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
        kVar.llsid = com.kwad.sdk.core.response.b.e.dM(adTemplate);
        int ed = com.kwad.sdk.core.response.b.e.ed(adTemplate);
        kVar.score = ed;
        if (ed > 0) {
            i = 1;
        } else {
            i = 0;
        }
        kVar.avD = i;
        return kVar;
    }
}
