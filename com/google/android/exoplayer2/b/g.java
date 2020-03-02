package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mDm;

    public g(f... fVarArr) {
        this.mDm = fVarArr;
        this.length = fVarArr.length;
    }

    public f LI(int i) {
        return this.mDm[i];
    }

    public f[] dyB() {
        return (f[]) this.mDm.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mDm) + 527;
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
        return Arrays.equals(this.mDm, ((g) obj).mDm);
    }
}
