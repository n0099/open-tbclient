package com.facebook.imagepipeline.common;
/* loaded from: classes7.dex */
public class e {
    private static final e plf = new e(-1, false);
    private static final e plg = new e(-2, false);
    private static final e plh = new e(-1, true);
    private final int mRotation;
    private final boolean ple;

    public static e etA() {
        return plf;
    }

    public static e etB() {
        return plh;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.ple = z;
    }

    public boolean etC() {
        return this.mRotation == -1;
    }

    public boolean etD() {
        return this.mRotation != -2;
    }

    public int etE() {
        if (etC()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean etF() {
        return this.ple;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.ple));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.ple == eVar.ple;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.ple));
    }
}
