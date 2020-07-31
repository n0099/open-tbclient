package com.facebook.imagepipeline.common;
/* loaded from: classes3.dex */
public class e {
    private static final e naC = new e(-1, false);
    private static final e naD = new e(-2, false);
    private static final e naE = new e(-1, true);
    private final int mRotation;
    private final boolean naB;

    public static e dGp() {
        return naC;
    }

    public static e dGq() {
        return naD;
    }

    public static e dGr() {
        return naE;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.naB = z;
    }

    public boolean dGs() {
        return this.mRotation == -1;
    }

    public boolean dGt() {
        return this.mRotation != -2;
    }

    public int dGu() {
        if (dGs()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dGv() {
        return this.naB;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.naB));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.naB == eVar.naB;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.naB));
    }
}
