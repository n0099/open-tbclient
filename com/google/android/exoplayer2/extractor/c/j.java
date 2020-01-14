package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public final class j {
    public final int id;
    public final Format lYQ;
    public final long lYV;
    public final int meg;
    public final long mjR;
    public final int mjS;
    @Nullable
    public final long[] mjT;
    @Nullable
    public final long[] mjU;
    @Nullable
    private final k[] mjV;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mjR = j2;
        this.lYV = j3;
        this.lYQ = format;
        this.mjS = i3;
        this.mjV = kVarArr;
        this.meg = i4;
        this.mjT = jArr;
        this.mjU = jArr2;
    }

    public k JL(int i) {
        if (this.mjV == null) {
            return null;
        }
        return this.mjV[i];
    }
}
