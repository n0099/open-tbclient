package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class u {
    public static final u lZJ = new u(0);
    public final int lZK;

    public u(int i) {
        this.lZK = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lZK == ((u) obj).lZK;
    }

    public int hashCode() {
        return this.lZK;
    }
}
