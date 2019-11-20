package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d khj = new d(-1, false);
    private static final d khk = new d(-2, false);
    private static final d khl = new d(-1, true);
    private final boolean khi;
    private final int mRotation;

    public static d cFW() {
        return khj;
    }

    public static d cFX() {
        return khl;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.khi = z;
    }

    public boolean cFY() {
        return this.mRotation == -1;
    }

    public boolean cFZ() {
        return this.mRotation != -2;
    }

    public int cGa() {
        if (cFY()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cGb() {
        return this.khi;
    }

    public int hashCode() {
        return com.facebook.common.util.a.d(Integer.valueOf(this.mRotation), Boolean.valueOf(this.khi));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.khi == dVar.khi;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.khi));
    }
}
