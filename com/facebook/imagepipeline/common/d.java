package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jZb = new d(-1, false);
    private static final d jZc = new d(-2, false);
    private static final d jZd = new d(-1, true);
    private final boolean jZa;
    private final int mRotation;

    public static d cEO() {
        return jZb;
    }

    public static d cEP() {
        return jZd;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jZa = z;
    }

    public boolean cEQ() {
        return this.mRotation == -1;
    }

    public boolean cER() {
        return this.mRotation != -2;
    }

    public int cES() {
        if (cEQ()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cET() {
        return this.jZa;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZa));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jZa == dVar.jZa;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZa));
    }
}
