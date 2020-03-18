package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class e implements q {
    private final q[] msX;

    public e(q[] qVarArr) {
        this.msX = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwF() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.msX) {
            long dwF = qVar.dwF();
            if (dwF != Long.MIN_VALUE) {
                j = Math.min(j, dwF);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwG() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.msX) {
            long dwG = qVar.dwG();
            if (dwG != Long.MIN_VALUE) {
                j = Math.min(j, dwG);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final boolean ge(long j) {
        q[] qVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long dwG = dwG();
            if (dwG == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.msX) {
                long dwG2 = qVar.dwG();
                boolean z3 = dwG2 != Long.MIN_VALUE && dwG2 <= j;
                if (dwG2 == dwG || z3) {
                    z |= qVar.ge(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
