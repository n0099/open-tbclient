package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public final class e implements q {
    private final q[] mqx;

    public e(q[] qVarArr) {
        this.mqx = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long duV() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mqx) {
            long duV = qVar.duV();
            if (duV != Long.MIN_VALUE) {
                j = Math.min(j, duV);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long duW() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mqx) {
            long duW = qVar.duW();
            if (duW != Long.MIN_VALUE) {
                j = Math.min(j, duW);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final boolean gf(long j) {
        q[] qVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long duW = duW();
            if (duW == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mqx) {
                long duW2 = qVar.duW();
                boolean z3 = duW2 != Long.MIN_VALUE && duW2 <= j;
                if (duW2 == duW || z3) {
                    z |= qVar.gf(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
