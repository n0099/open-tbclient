package com.kwad.sdk.live.a;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
/* loaded from: classes6.dex */
public class b extends d {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f36356a;

        /* renamed from: b  reason: collision with root package name */
        public String f36357b;
    }

    public b(a aVar) {
        a(URLPackage.KEY_AUTHOR_ID, aVar.f36356a);
        b("liveStreamId", aVar.f36357b);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        return com.kwad.sdk.d.n();
    }
}
