package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class u {
    public static final u mbF = new u(0);
    public final int mbG;

    public u(int i) {
        this.mbG = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mbG == ((u) obj).mbG;
    }

    public int hashCode() {
        return this.mbG;
    }
}
