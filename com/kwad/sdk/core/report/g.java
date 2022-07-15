package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes5.dex */
public class g extends com.kwad.sdk.core.response.kwai.a {
    public long a;
    public long b;
    public int c;
    public int d;
    public String e = "union";

    public static g a(AdTemplate adTemplate) {
        g gVar = new g();
        gVar.b = com.kwad.sdk.core.response.a.d.t(adTemplate);
        gVar.a = com.kwad.sdk.core.response.a.d.f(adTemplate);
        int y = com.kwad.sdk.core.response.a.d.y(adTemplate);
        gVar.c = y;
        gVar.d = y > 0 ? 1 : 0;
        return gVar;
    }

    public final String a() {
        return toJson().toString();
    }
}
