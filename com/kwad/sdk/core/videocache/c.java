package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes7.dex */
public final class c {
    public final File aeh;
    public final com.kwad.sdk.core.videocache.kwai.c aei;
    public final com.kwad.sdk.core.videocache.kwai.a aej;
    public final com.kwad.sdk.core.videocache.c.b aek;
    public final com.kwad.sdk.core.videocache.a.b ael;

    public c(File file, com.kwad.sdk.core.videocache.kwai.c cVar, com.kwad.sdk.core.videocache.kwai.a aVar, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.aeh = file;
        this.aei = cVar;
        this.aej = aVar;
        this.aek = bVar;
        this.ael = bVar2;
    }

    public final File cx(String str) {
        return new File(this.aeh, this.aei.generate(str));
    }
}
