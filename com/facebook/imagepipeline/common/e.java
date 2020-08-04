package com.facebook.imagepipeline.common;
/* loaded from: classes3.dex */
public class e {
    private static final e naE = new e(-1, false);
    private static final e naF = new e(-2, false);
    private static final e naG = new e(-1, true);
    private final int mRotation;
    private final boolean naD;

    public static e dGq() {
        return naE;
    }

    public static e dGr() {
        return naF;
    }

    public static e dGs() {
        return naG;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.naD = z;
    }

    public boolean dGt() {
        return this.mRotation == -1;
    }

    public boolean dGu() {
        return this.mRotation != -2;
    }

    public int dGv() {
        if (dGt()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dGw() {
        return this.naD;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.naD));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.naD == eVar.naD;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.naD));
    }
}
