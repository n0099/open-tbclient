package com.facebook.imagepipeline.common;
/* loaded from: classes5.dex */
public class e {
    private static final e pxQ = new e(-1, false);
    private static final e pxR = new e(-2, false);
    private static final e pxS = new e(-1, true);
    private final int mRotation;
    private final boolean pxP;

    public static e etU() {
        return pxQ;
    }

    public static e etV() {
        return pxS;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pxP = z;
    }

    public boolean etW() {
        return this.mRotation == -1;
    }

    public boolean etX() {
        return this.mRotation != -2;
    }

    public int etY() {
        if (etW()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean etZ() {
        return this.pxP;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pxP));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pxP == eVar.pxP;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pxP));
    }
}
