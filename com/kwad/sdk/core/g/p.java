package com.kwad.sdk.core.g;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class p extends com.kwad.sdk.core.network.d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f9601a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f9602b;
        public long c;
        public long d;
        public String e;
    }

    public p(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f9601a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_AUTHOR_ID, aVar.c);
        a("tabId", aVar.d);
        a("contentInfo", aVar.f9602b);
        b("pcursor", aVar.e);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
