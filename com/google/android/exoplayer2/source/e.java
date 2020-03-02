package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
/* loaded from: classes6.dex */
public final class e implements q {
    private final q[] mrf;

    public e(q[] qVarArr) {
        this.mrf = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwh() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrf) {
            long dwh = qVar.dwh();
            if (dwh != Long.MIN_VALUE) {
                j = Math.min(j, dwh);
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long dwi() {
        long j = Long.MAX_VALUE;
        for (q qVar : this.mrf) {
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
    public final boolean gd(long j) {
        q[] qVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long dwi = dwi();
            if (dwi == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (q qVar : this.mrf) {
                long dwi2 = qVar.dwi();
                boolean z3 = dwi2 != Long.MIN_VALUE && dwi2 <= j;
                if (dwi2 == dwi || z3) {
                    z |= qVar.gd(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
