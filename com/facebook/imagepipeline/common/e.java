package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e lTB = new e(-1, false);
    private static final e lTC = new e(-2, false);
    private static final e lTD = new e(-1, true);
    private final boolean lTA;
    private final int mRotation;

    public static e doU() {
        return lTB;
    }

    public static e doV() {
        return lTC;
    }

    public static e doW() {
        return lTD;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lTA = z;
    }

    public boolean doX() {
        return this.mRotation == -1;
    }

    public boolean doY() {
        return this.mRotation != -2;
    }

    public int doZ() {
        if (doX()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dpa() {
        return this.lTA;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lTA));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lTA == eVar.lTA;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lTA));
    }
}
