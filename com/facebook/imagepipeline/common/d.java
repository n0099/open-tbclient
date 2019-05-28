package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jZc = new d(-1, false);
    private static final d jZd = new d(-2, false);
    private static final d jZe = new d(-1, true);
    private final boolean jZb;
    private final int mRotation;

    public static d cEQ() {
        return jZc;
    }

    public static d cER() {
        return jZe;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jZb = z;
    }

    public boolean cES() {
        return this.mRotation == -1;
    }

    public boolean cET() {
        return this.mRotation != -2;
    }

    public int cEU() {
        if (cES()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cEV() {
        return this.jZb;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZb));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jZb == dVar.jZb;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZb));
    }
}
