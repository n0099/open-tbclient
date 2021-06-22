package com.kwad.sdk.core.g;

import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class p extends com.kwad.sdk.core.network.d {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.f f34557a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.core.g.a.c f34558b;

        /* renamed from: c  reason: collision with root package name */
        public long f34559c;

        /* renamed from: d  reason: collision with root package name */
        public long f34560d;

        /* renamed from: e  reason: collision with root package name */
        public String f34561e;
    }

    public p(a aVar) {
        JSONArray jSONArray = new JSONArray();
        com.kwad.sdk.utils.o.a(jSONArray, aVar.f34557a.toJson());
        a("impInfo", jSONArray);
        a(URLPackage.KEY_AUTHOR_ID, aVar.f34559c);
        a("tabId", aVar.f34560d);
        a("contentInfo", aVar.f34558b);
        b("pcursor", aVar.f34561e);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.l();
    }
}
