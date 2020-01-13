package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes5.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e mdj;
    public final Format msu;
    public final int msv;
    public final Object msw;
    public final long msx;
    public final long msy;
    public final int type;

    public abstract long dvx();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.mdj = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.msu = format;
        this.msv = i2;
        this.msw = obj;
        this.msx = j;
        this.msy = j2;
    }

    public final long dso() {
        return this.msy - this.msx;
    }
}
