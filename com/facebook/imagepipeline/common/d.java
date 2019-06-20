package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jZf = new d(-1, false);
    private static final d jZg = new d(-2, false);
    private static final d jZh = new d(-1, true);
    private final boolean jZe;
    private final int mRotation;

    public static d cEP() {
        return jZf;
    }

    public static d cEQ() {
        return jZh;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jZe = z;
    }

    public boolean cER() {
        return this.mRotation == -1;
    }

    public boolean cES() {
        return this.mRotation != -2;
    }

    public int cET() {
        if (cER()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cEU() {
        return this.jZe;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZe));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jZe == dVar.jZe;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jZe));
    }
}
