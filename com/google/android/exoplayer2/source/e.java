package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes5.dex */
public final class e implements q {
    private final q[] mqs;

    public e(q[] qVarArr) {
        this.mqs = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long duT() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mqs) {
            long duT = qVar.duT();
            if (duT != Long.MIN_VALUE) {
                j = Math.min(j, duT);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long duU() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mqs) {
            long duU = qVar.duU();
            if (duU != Long.MIN_VALUE) {
                j = Math.min(j, duU);
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
            long duU = duU();
            if (duU == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mqs) {
                long duU2 = qVar.duU();
                boolean z3 = duU2 != Long.MIN_VALUE && duU2 <= j;
                if (duU2 == duU || z3) {
                    z |= qVar.gf(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
