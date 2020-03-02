package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes6.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e mdW;
    public final Format mth;
    public final int mti;
    public final Object mtj;
    public final long mtk;
    public final long mtl;
    public final int type;

    public abstract long dwL();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.mdW = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.mth = format;
        this.mti = i2;
        this.mtj = obj;
        this.mtk = j;
        this.mtl = j2;
    }

    public final long getDurationUs() {
        return this.mtl - this.mtk;
    }
}
