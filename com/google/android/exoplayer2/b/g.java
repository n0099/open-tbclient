package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mCy;

    public g(f... fVarArr) {
        this.mCy = fVarArr;
        this.length = fVarArr.length;
    }

    public f LD(int i) {
        return this.mCy[i];
    }

    public f[] dxn() {
        return (f[]) this.mCy.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mCy) + 527;
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
        return Arrays.equals(this.mCy, ((g) obj).mCy);
    }
}
