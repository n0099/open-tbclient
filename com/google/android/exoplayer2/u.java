package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class u {
    public static final u lZL = new u(0);
    public final int lZM;

    public u(int i) {
        this.lZM = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.lZM == ((u) obj).lZM;
    }

    public int hashCode() {
        return this.lZM;
    }
}
