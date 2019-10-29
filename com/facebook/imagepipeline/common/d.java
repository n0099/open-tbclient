package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d kia = new d(-1, false);
    private static final d kib = new d(-2, false);
    private static final d kic = new d(-1, true);
    private final boolean khZ;
    private final int mRotation;

    public static d cFY() {
        return kia;
    }

    public static d cFZ() {
        return kic;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.khZ = z;
    }

    public boolean cGa() {
        return this.mRotation == -1;
    }

    public boolean cGb() {
        return this.mRotation != -2;
    }

    public int cGc() {
        if (cGa()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cGd() {
        return this.khZ;
    }

    public int hashCode() {
        return com.facebook.common.util.a.d(Integer.valueOf(this.mRotation), Boolean.valueOf(this.khZ));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.khZ == dVar.khZ;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.khZ));
    }
}
