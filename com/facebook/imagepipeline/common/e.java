package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e nEJ = new e(-1, false);
    private static final e nEK = new e(-2, false);
    private static final e nEL = new e(-1, true);
    private final int mRotation;
    private final boolean nEI;

    public static e dWw() {
        return nEJ;
    }

    public static e dWx() {
        return nEK;
    }

    public static e dWy() {
        return nEL;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.nEI = z;
    }

    public boolean dWz() {
        return this.mRotation == -1;
    }

    public boolean dWA() {
        return this.mRotation != -2;
    }

    public int dWB() {
        if (dWz()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dWC() {
        return this.nEI;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.nEI));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.nEI == eVar.nEI;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.nEI));
    }
}
