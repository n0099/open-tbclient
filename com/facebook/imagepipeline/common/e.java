package com.facebook.imagepipeline.common;
/* loaded from: classes7.dex */
public class e {
    private static final e plh = new e(-1, false);
    private static final e pli = new e(-2, false);
    private static final e plj = new e(-1, true);
    private final int mRotation;
    private final boolean plg;

    public static e etB() {
        return plh;
    }

    public static e etC() {
        return plj;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.plg = z;
    }

    public boolean etD() {
        return this.mRotation == -1;
    }

    public boolean etE() {
        return this.mRotation != -2;
    }

    public int etF() {
        if (etD()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean etG() {
        return this.plg;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.plg));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.plg == eVar.plg;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.plg));
    }
}
