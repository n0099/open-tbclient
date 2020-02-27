package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class j {
    public final int id;
    public final long lZB;
    public final Format lZw;
    public final int meM;
    @Nullable
    public final long[] mkA;
    @Nullable
    private final k[] mkB;
    public final long mkx;
    public final int mky;
    @Nullable
    public final long[] mkz;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mkx = j2;
        this.lZB = j3;
        this.lZw = format;
        this.mky = i3;
        this.mkB = kVarArr;
        this.meM = i4;
        this.mkz = jArr;
        this.mkA = jArr2;
    }

    public k JQ(int i) {
        if (this.mkB == null) {
            return null;
        }
        return this.mkB[i];
    }
}
