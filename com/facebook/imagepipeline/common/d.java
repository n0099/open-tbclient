package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jGT = new d(-1, false);
    private static final d jGU = new d(-2, false);
    private static final d jGV = new d(-1, true);
    private final boolean jGS;
    private final int mRotation;

    public static d cwZ() {
        return jGT;
    }

    public static d cxa() {
        return jGV;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jGS = z;
    }

    public boolean cxb() {
        return this.mRotation == -1;
    }

    public boolean cxc() {
        return this.mRotation != -2;
    }

    public int cxd() {
        if (cxb()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cxe() {
        return this.jGS;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGS));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jGS == dVar.jGS;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGS));
    }
}
