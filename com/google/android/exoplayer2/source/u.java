package com.google.android.exoplayer2.source;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class u {
    public static final u muU = new u(new t[0]);
    private int hashCode;
    public final int length;
    private final t[] muV;

    public u(t... tVarArr) {
        this.muV = tVarArr;
        this.length = tVarArr.length;
    }

    public t KX(int i) {
        return this.muV[i];
    }

    public int a(t tVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.muV[i] == tVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.muV);
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
        u uVar = (u) obj;
        return this.length == uVar.length && Arrays.equals(this.muV, uVar.muV);
    }
}
