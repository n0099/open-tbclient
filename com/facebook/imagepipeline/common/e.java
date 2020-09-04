package com.facebook.imagepipeline.common;
/* loaded from: classes8.dex */
public class e {
    private static final e nuM = new e(-1, false);
    private static final e nuN = new e(-2, false);
    private static final e nuO = new e(-1, true);
    private final int mRotation;
    private final boolean nuL;

    public static e dSy() {
        return nuM;
    }

    public static e dSz() {
        return nuN;
    }

    public static e dSA() {
        return nuO;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.nuL = z;
    }

    public boolean dSB() {
        return this.mRotation == -1;
    }

    public boolean dSC() {
        return this.mRotation != -2;
    }

    public int dSD() {
        if (dSB()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dSE() {
        return this.nuL;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.nuL));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.nuL == eVar.nuL;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.nuL));
    }
}
