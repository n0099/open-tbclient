package com.google.android.exoplayer2;
/* loaded from: classes4.dex */
public final class u {
    public static final u lVh = new u(0);
    public final int lVi;

    public u(int i) {
        this.lVi = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lVi == ((u) obj).lVi;
    }

    public int hashCode() {
        return this.lVi;
    }
}
