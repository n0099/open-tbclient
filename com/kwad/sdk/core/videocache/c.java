package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes5.dex */
public final class c {
    public final File a;
    public final com.kwad.sdk.core.videocache.kwai.c b;
    public final com.kwad.sdk.core.videocache.kwai.a c;
    public final com.kwad.sdk.core.videocache.c.b d;
    public final com.kwad.sdk.core.videocache.a.b e;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = bVar;
        this.e = bVar2;
    }

    public final File a(String str) {
        return new File(this.a, this.b.a(str));
    }
}
