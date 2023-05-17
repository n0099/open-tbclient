package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes9.dex */
public class g extends com.kwad.sdk.core.response.kwai.a {
    public int ZZ;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static g aH(AdTemplate adTemplate) {
        g gVar = new g();
        gVar.creativeId = com.kwad.sdk.core.response.a.d.ca(adTemplate);
        gVar.llsid = com.kwad.sdk.core.response.a.d.bN(adTemplate);
        int cf = com.kwad.sdk.core.response.a.d.cf(adTemplate);
        gVar.score = cf;
        gVar.ZZ = cf > 0 ? 1 : 0;
        return gVar;
    }

    public final String ux() {
        return toJson().toString();
    }
}
