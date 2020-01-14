package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes5.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e mdo;
    public final int msA;
    public final Object msB;
    public final long msC;
    public final long msD;
    public final Format msz;
    public final int type;

    public abstract long dvz();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.mdo = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.msz = format;
        this.msA = i2;
        this.msB = obj;
        this.msC = j;
        this.msD = j2;
    }

    public final long dsq() {
        return this.msD - this.msC;
    }
}
