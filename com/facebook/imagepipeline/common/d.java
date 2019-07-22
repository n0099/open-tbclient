package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d kgl = new d(-1, false);
    private static final d kgm = new d(-2, false);
    private static final d kgn = new d(-1, true);
    private final boolean kgk;
    private final int mRotation;

    public static d cHS() {
        return kgl;
    }

    public static d cHT() {
        return kgn;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.kgk = z;
    }

    public boolean cHU() {
        return this.mRotation == -1;
    }

    public boolean cHV() {
        return this.mRotation != -2;
    }

    public int cHW() {
        if (cHU()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cHX() {
        return this.kgk;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.kgk));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.kgk == dVar.kgk;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.kgk));
    }
}
