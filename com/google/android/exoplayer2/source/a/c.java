package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
/* loaded from: classes6.dex */
public abstract class c implements Loader.c {
    public final com.google.android.exoplayer2.upstream.g dataSpec;
    protected final com.google.android.exoplayer2.upstream.e meh;
    public final Format mts;
    public final int mtt;
    public final Object mtu;
    public final long mtv;
    public final long mtw;
    public final int type;

    public abstract long dwM();

    public c(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, int i, Format format, int i2, Object obj, long j, long j2) {
        this.meh = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
        this.dataSpec = (com.google.android.exoplayer2.upstream.g) com.google.android.exoplayer2.util.a.checkNotNull(gVar);
        this.type = i;
        this.mts = format;
        this.mtt = i2;
        this.mtu = obj;
        this.mtv = j;
        this.mtw = j2;
    }

    public final long getDurationUs() {
        return this.mtw - this.mtv;
    }
}
