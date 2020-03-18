package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes6.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e mfN;
    public final Format muZ;
    public final int mva;
    public final Object mvb;
    public final long mvc;
    public final long mvd;
    public final int type;

    public abstract long dxj();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.mfN = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.muZ = format;
        this.mva = i2;
        this.mvb = obj;
        this.mvc = j;
        this.mvd = j2;
    }

    public final long getDurationUs() {
        return this.mvd - this.mvc;
    }
}
