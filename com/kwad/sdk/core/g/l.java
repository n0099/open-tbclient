package com.kwad.sdk.core.g;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class l extends com.kwad.sdk.core.network.d {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f9282a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f9283b;
        public String c;
    }

    public l(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f9282a.toJson());
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f9283b);
        b("photoId", aVar.c);
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.r();
    }
}
