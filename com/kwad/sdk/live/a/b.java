package com.kwad.sdk.live.a;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
/* loaded from: classes7.dex */
public class b extends d {

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f36874a;

        /* renamed from: b  reason: collision with root package name */
        public String f36875b;
    }

    public b(a aVar) {
        a(URLPackage.KEY_AUTHOR_ID, aVar.f36874a);
        b("liveStreamId", aVar.f36875b);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.n();
    }
}
