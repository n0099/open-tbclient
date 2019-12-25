package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public final class j {
    public final int id;
    public final Format lUU;
    public final long lUZ;
    public final int mak;
    public final long mfV;
    public final int mfW;
    @Nullable
    public final long[] mfX;
    @Nullable
    public final long[] mfY;
    @Nullable
    private final k[] mfZ;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mfV = j2;
        this.lUZ = j3;
        this.lUU = format;
        this.mfW = i3;
        this.mfZ = kVarArr;
        this.mak = i4;
        this.mfX = jArr;
        this.mfY = jArr2;
    }

    public k JC(int i) {
        if (this.mfZ == null) {
            return null;
        }
        return this.mfZ[i];
    }
}
