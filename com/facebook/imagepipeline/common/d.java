package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d ipU = new d(-1, false);
    private static final d ipV = new d(-2, false);
    private static final d ipW = new d(-1, true);
    private final boolean ipT;
    private final int mRotation;

    public static d bXd() {
        return ipU;
    }

    public static d bXe() {
        return ipW;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.ipT = z;
    }

    public boolean bXf() {
        return this.mRotation == -1;
    }

    public boolean bXg() {
        return this.mRotation != -2;
    }

    public int bXh() {
        if (bXf()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean bXi() {
        return this.ipT;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.ipT));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.ipT == dVar.ipT;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.ipT));
    }
}
