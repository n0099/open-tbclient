package com.kwad.sdk.core.g;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class l extends com.kwad.sdk.core.network.d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f33809a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f33810b;

        /* renamed from: c  reason: collision with root package name */
        public String f33811c;
    }

    public l(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f33809a.toJson());
        a("impInfo", jSONArray);
        a("contentInfo", aVar.f33810b);
        b("photoId", aVar.f33811c);
        b("appTag", ae.g(KsAdSDKImpl.get().getContext()));
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.r();
    }
}
