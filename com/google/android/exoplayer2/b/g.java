package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] mCD;

    public g(f... fVarArr) {
        this.mCD = fVarArr;
        this.length = fVarArr.length;
    }

    public f LD(int i) {
        return this.mCD[i];
    }

    public f[] dxp() {
        return (f[]) this.mCD.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mCD) + 527;
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
        return Arrays.equals(this.mCD, ((g) obj).mCD);
    }
}
