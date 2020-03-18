package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mFg;

    public g(f... fVarArr) {
        this.mFg = fVarArr;
        this.length = fVarArr.length;
    }

    public f LO(int i) {
        return this.mFg[i];
    }

    public f[] dyZ() {
        return (f[]) this.mFg.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mFg) + 527;
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mFg, ((g) obj).mFg);
    }
}
