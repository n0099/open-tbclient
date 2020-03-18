package com.google.android.exoplayer2.extractor.c;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class j {
    public final int id;
    public final Format mbs;
    public final long mbx;
    public final int mgF;
    public final long mmq;
    public final int mmr;
    @Nullable
    public final long[] mms;
    @Nullable
    public final long[] mmt;
    @Nullable
    private final k[] mmu;
    public final long timescale;
    public final int type;

    public j(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable k[] kVarArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.mmq = j2;
        this.mbx = j3;
        this.mbs = format;
        this.mmr = i3;
        this.mmu = kVarArr;
        this.mgF = i4;
        this.mms = jArr;
        this.mmt = jArr2;
    }

    public k JW(int i) {
        if (this.mmu == null) {
            return null;
        }
        return this.mmu[i];
    }
}
