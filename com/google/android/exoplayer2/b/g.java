package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mDz;

    public g(f... fVarArr) {
        this.mDz = fVarArr;
        this.length = fVarArr.length;
    }

    public f LI(int i) {
        return this.mDz[i];
    }

    public f[] dyC() {
        return (f[]) this.mDz.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mDz) + 527;
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
        return Arrays.equals(this.mDz, ((g) obj).mDz);
    }
}
