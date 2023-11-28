package com.kwad.sdk.core.videocache;

import java.io.File;
/* loaded from: classes10.dex */
public final class c {
    public final File aAD;
    public final com.kwad.sdk.core.videocache.a.c aAE;
    public final com.kwad.sdk.core.videocache.a.a aAF;
    public final com.kwad.sdk.core.videocache.d.c aAG;
    public final com.kwad.sdk.core.videocache.b.b aAH;
    public final int aAI;
    public final int aAJ;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.aAD = file;
        this.aAE = cVar;
        this.aAF = aVar;
        this.aAG = cVar2;
        this.aAH = bVar;
        this.aAI = i;
        this.aAJ = i2;
    }

    public final File ec(String str) {
        return new File(this.aAD, this.aAE.generate(str));
    }
}
