package com.google.android.exoplayer2;
/* loaded from: classes5.dex */
public final class u {
    public static final u lZd = new u(0);
    public final int lZe;

    public u(int i) {
        this.lZe = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lZe == ((u) obj).lZe;
    }

    public int hashCode() {
        return this.lZe;
    }
}
