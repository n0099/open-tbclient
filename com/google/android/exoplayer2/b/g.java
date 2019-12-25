package com.google.android.exoplayer2.b;

import java.util.Arrays;
/* loaded from: classes4.dex */
public final class g {
    private int hashCode;
    public final int length;
    private final f[] myI;

    public g(f... fVarArr) {
        this.myI = fVarArr;
        this.length = fVarArr.length;
    }

    public f Lu(int i) {
        return this.myI[i];
    }

    public f[] dwc() {
        return (f[]) this.myI.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.myI) + 527;
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
        return Arrays.equals(this.myI, ((g) obj).myI);
    }
}
