package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class j {
    public final int id;
    public final Format lZJ;
    public final long lZO;
    public final int meZ;
    public final long mkK;
    public final int mkL;
    @Nullable
    public final long[] mkM;
    @Nullable
    public final long[] mkN;
    @Nullable
    private final k[] mkO;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mkK = j2;
        this.lZO = j3;
        this.lZJ = format;
        this.mkL = i3;
        this.mkO = kVarArr;
        this.meZ = i4;
        this.mkM = jArr;
        this.mkN = jArr2;
    }

    public k JQ(int i) {
        if (this.mkO == null) {
            return null;
        }
        return this.mkO[i];
    }
}
