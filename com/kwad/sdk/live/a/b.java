package com.kwad.sdk.live.a;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
/* loaded from: classes3.dex */
public class b extends d {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6908a;
        public String b;
    }

    public b(a aVar) {
        a(URLPackage.KEY_AUTHOR_ID, aVar.f6908a);
        b("liveStreamId", aVar.b);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.n();
    }
}
