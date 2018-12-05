package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d imJ = new d(-1, false);
    private static final d imK = new d(-2, false);
    private static final d imL = new d(-1, true);
    private final boolean imI;
    private final int mRotation;

    public static d bWn() {
        return imJ;
    }

    public static d bWo() {
        return imL;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.imI = z;
    }

    public boolean bWp() {
        return this.mRotation == -1;
    }

    public boolean bWq() {
        return this.mRotation != -2;
    }

    public int bWr() {
        if (bWp()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean bWs() {
        return this.imI;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.imI));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.imI == dVar.imI;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.imI));
    }
}
