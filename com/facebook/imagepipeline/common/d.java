package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d irb = new d(-1, false);
    private static final d irc = new d(-2, false);
    private static final d ird = new d(-1, true);
    private final boolean ira;
    private final int mRotation;

    public static d bXL() {
        return irb;
    }

    public static d bXM() {
        return ird;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.ira = z;
    }

    public boolean bXN() {
        return this.mRotation == -1;
    }

    public boolean bXO() {
        return this.mRotation != -2;
    }

    public int bXP() {
        if (bXN()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean bXQ() {
        return this.ira;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.ira));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.ira == dVar.ira;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.ira));
    }
}
