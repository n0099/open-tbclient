package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class e implements q {
    private final q[] mrq;

    public e(q[] qVarArr) {
        this.mrq = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwi() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrq) {
            long dwi = qVar.dwi();
            if (dwi != Long.MIN_VALUE) {
                j = Math.min(j, dwi);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwj() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrq) {
            long dwj = qVar.dwj();
            if (dwj != Long.MIN_VALUE) {
                j = Math.min(j, dwj);
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
            long dwj = dwj();
            if (dwj == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mrq) {
                long dwj2 = qVar.dwj();
                boolean z3 = dwj2 != Long.MIN_VALUE && dwj2 <= j;
                if (dwj2 == dwj || z3) {
                    z |= qVar.gd(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
