package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class u {
    public static final u lZW = new u(0);
    public final int lZX;

    public u(int i) {
        this.lZX = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lZX == ((u) obj).lZX;
    }

    public int hashCode() {
        return this.lZX;
    }
}
