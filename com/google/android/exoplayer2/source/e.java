package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes4.dex */
public final class e implements q {
    private final q[] mmD;

    public e(q[] qVarArr) {
        this.mmD = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dtI() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mmD) {
            long dtI = qVar.dtI();
            if (dtI != Long.MIN_VALUE) {
                j = Math.min(j, dtI);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dtJ() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mmD) {
            long dtJ = qVar.dtJ();
            if (dtJ != Long.MIN_VALUE) {
                j = Math.min(j, dtJ);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final boolean ga(long j) {
        q[] qVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long dtJ = dtJ();
            if (dtJ == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mmD) {
                long dtJ2 = qVar.dtJ();
                boolean z3 = dtJ2 != Long.MIN_VALUE && dtJ2 <= j;
                if (dtJ2 == dtJ || z3) {
                    z |= qVar.ga(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
