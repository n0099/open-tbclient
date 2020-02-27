package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mDk;

    public g(f... fVarArr) {
        this.mDk = fVarArr;
        this.length = fVarArr.length;
    }

    public f LI(int i) {
        return this.mDk[i];
    }

    public f[] dyz() {
        return (f[]) this.mDk.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mDk) + 527;
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
        return Arrays.equals(this.mDk, ((g) obj).mDk);
    }
}
