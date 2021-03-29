package com.kwad.sdk.core.g;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class p extends com.kwad.sdk.core.network.d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f33832a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f33833b;

        /* renamed from: c  reason: collision with root package name */
        public long f33834c;

        /* renamed from: d  reason: collision with root package name */
        public long f33835d;

        /* renamed from: e  reason: collision with root package name */
        public String f33836e;
    }

    public p(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f33832a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_AUTHOR_ID, aVar.f33834c);
        a("tabId", aVar.f33835d);
        a("contentInfo", aVar.f33833b);
        b("pcursor", aVar.f33836e);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
