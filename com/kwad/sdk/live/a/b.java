package com.kwad.sdk.live.a;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
/* loaded from: classes5.dex */
public class b extends d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f10778a;

        /* renamed from: b  reason: collision with root package name */
        public String f10779b;
    }

    public b(a aVar) {
        a(URLPackage.KEY_AUTHOR_ID, aVar.f10778a);
        b("liveStreamId", aVar.f10779b);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.n();
    }
}
