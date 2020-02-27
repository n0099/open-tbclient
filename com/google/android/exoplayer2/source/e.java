package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class e implements q {
    private final q[] mrd;

    public e(q[] qVarArr) {
        this.mrd = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwf() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrd) {
            long dwf = qVar.dwf();
            if (dwf != Long.MIN_VALUE) {
                j = Math.min(j, dwf);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwg() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrd) {
            long dwg = qVar.dwg();
            if (dwg != Long.MIN_VALUE) {
                j = Math.min(j, dwg);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final boolean gd(long j) {
        q[] qVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long dwg = dwg();
            if (dwg == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mrd) {
                long dwg2 = qVar.dwg();
                boolean z3 = dwg2 != Long.MIN_VALUE && dwg2 <= j;
                if (dwg2 == dwg || z3) {
                    z |= qVar.gd(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
