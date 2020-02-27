package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public abstract class l extends c {
    public final int mtO;

    public abstract boolean dwP();

    public l(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2) {
        super(eVar, gVar, 1, format, i, obj, j, j2);
        com.google.android.exoplayer2.util.a.checkNotNull(format);
        this.mtO = i2;
    }

    public int dwO() {
        return this.mtO + 1;
    }
}
