package com.google.android.exoplayer2.source;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class u {
    public static final u mtn = new u(new t[0]);
    private int hashCode;
    public final int length;
    private final t[] mto;

    public u(t... tVarArr) {
        this.mto = tVarArr;
        this.length = tVarArr.length;
    }

    public t KR(int i) {
        return this.mto[i];
    }

    public int a(t tVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.mto[i] == tVar) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.mto);
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
        return this.length == uVar.length && Arrays.equals(this.mto, uVar.mto);
    }
}
