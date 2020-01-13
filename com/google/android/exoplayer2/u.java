package com.google.android.exoplayer2;
/* loaded from: classes5.dex */
public final class u {
    public static final u lYY = new u(0);
    public final int lYZ;

    public u(int i) {
        this.lYZ = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lYZ == ((u) obj).lYZ;
    }

    public int hashCode() {
        return this.lYZ;
    }
}
