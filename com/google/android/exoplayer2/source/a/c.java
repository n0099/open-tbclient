package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes6.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e mdU;
    public final Format mtf;
    public final int mtg;
    public final Object mth;
    public final long mti;
    public final long mtj;
    public final int type;

    public abstract long dwJ();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.mdU = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.mtf = format;
        this.mtg = i2;
        this.mth = obj;
        this.mti = j;
        this.mtj = j2;
    }

    public final long getDurationUs() {
        return this.mtj - this.mti;
    }
}
