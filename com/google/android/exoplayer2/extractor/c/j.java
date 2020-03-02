package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class j {
    public final int id;
    public final long lZD;
    public final Format lZy;
    public final int meO;
    public final int mkA;
    @Nullable
    public final long[] mkB;
    @Nullable
    public final long[] mkC;
    @Nullable
    private final k[] mkD;
    public final long mkz;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mkz = j2;
        this.lZD = j3;
        this.lZy = format;
        this.mkA = i3;
        this.mkD = kVarArr;
        this.meO = i4;
        this.mkB = jArr;
        this.mkC = jArr2;
    }

    public k JQ(int i) {
        if (this.mkD == null) {
            return null;
        }
        return this.mkD[i];
    }
}
