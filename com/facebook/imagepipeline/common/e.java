package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e lQW = new e(-1, false);
    private static final e lQX = new e(-2, false);
    private static final e lQY = new e(-1, true);
    private final boolean lQV;
    private final int mRotation;

    public static e dnf() {
        return lQW;
    }

    public static e dng() {
        return lQX;
    }

    public static e dnh() {
        return lQY;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lQV = z;
    }

    public boolean dni() {
        return this.mRotation == -1;
    }

    public boolean dnj() {
        return this.mRotation != -2;
    }

    public int dnk() {
        if (dni()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dnl() {
        return this.lQV;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lQV));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lQV == eVar.lQV;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lQV));
    }
}
