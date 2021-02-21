package com.facebook.imagepipeline.common;
/* loaded from: classes5.dex */
public class e {
    private final int mRotation;
    private final boolean pIy;
    private static final e pIz = new e(-1, false);
    private static final e pIA = new e(-2, false);
    private static final e pIB = new e(-1, true);

    public static e ewu() {
        return pIz;
    }

    public static e ewv() {
        return pIB;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pIy = z;
    }

    public boolean eww() {
        return this.mRotation == -1;
    }

    public boolean ewx() {
        return this.mRotation != -2;
    }

    public int ewy() {
        if (eww()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean ewz() {
        return this.pIy;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pIy));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pIy == eVar.pIy;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pIy));
    }
}
