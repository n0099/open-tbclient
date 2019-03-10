package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jHb = new d(-1, false);
    private static final d jHc = new d(-2, false);
    private static final d jHd = new d(-1, true);
    private final boolean jHa;
    private final int mRotation;

    public static d cwW() {
        return jHb;
    }

    public static d cwX() {
        return jHd;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jHa = z;
    }

    public boolean cwY() {
        return this.mRotation == -1;
    }

    public boolean cwZ() {
        return this.mRotation != -2;
    }

    public int cxa() {
        if (cwY()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cxb() {
        return this.jHa;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jHa));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jHa == dVar.jHa;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jHa));
    }
}
