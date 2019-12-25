package com.google.android.exoplayer2.source;

import java.util.Arrays;
/* loaded from: classes4.dex */
public final class u {
    public static final u moA = new u(new t[0]);
    private int hashCode;
    public final int length;
    private final t[] moB;

    public u(t... tVarArr) {
        this.moB = tVarArr;
        this.length = tVarArr.length;
    }

    public t KD(int i) {
        return this.moB[i];
    }

    public int a(t tVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.moB[i] == tVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.moB);
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
        return this.length == uVar.length && Arrays.equals(this.moB, uVar.moB);
    }
}
