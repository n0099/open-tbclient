package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public final class j {
    public final int id;
    public final Format lYL;
    public final long lYQ;
    public final int meb;
    public final long mjM;
    public final int mjN;
    @Nullable
    public final long[] mjO;
    @Nullable
    public final long[] mjP;
    @Nullable
    private final k[] mjQ;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mjM = j2;
        this.lYQ = j3;
        this.lYL = format;
        this.mjN = i3;
        this.mjQ = kVarArr;
        this.meb = i4;
        this.mjO = jArr;
        this.mjP = jArr2;
    }

    public k JL(int i) {
        if (this.mjQ == null) {
            return null;
        }
        return this.mjQ[i];
    }
}
