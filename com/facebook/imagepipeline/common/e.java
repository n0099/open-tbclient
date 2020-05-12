package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mbs = new e(-1, false);
    private static final e mbt = new e(-2, false);
    private static final e mbu = new e(-1, true);
    private final int mRotation;
    private final boolean mbr;

    public static e dqR() {
        return mbs;
    }

    public static e dqS() {
        return mbt;
    }

    public static e dqT() {
        return mbu;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mbr = z;
    }

    public boolean dqU() {
        return this.mRotation == -1;
    }

    public boolean dqV() {
        return this.mRotation != -2;
    }

    public int dqW() {
        if (dqU()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dqX() {
        return this.mbr;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mbr));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mbr == eVar.mbr;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mbr));
    }
}
