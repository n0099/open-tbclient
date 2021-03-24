package com.kwad.sdk.core.g;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class p extends com.kwad.sdk.core.network.d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f33831a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f33832b;

        /* renamed from: c  reason: collision with root package name */
        public long f33833c;

        /* renamed from: d  reason: collision with root package name */
        public long f33834d;

        /* renamed from: e  reason: collision with root package name */
        public String f33835e;
    }

    public p(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f33831a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_AUTHOR_ID, aVar.f33833c);
        a("tabId", aVar.f33834d);
        a("contentInfo", aVar.f33832b);
        b("pcursor", aVar.f33835e);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
