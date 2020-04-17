package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mbo = new e(-1, false);
    private static final e mbp = new e(-2, false);
    private static final e mbq = new e(-1, true);
    private final int mRotation;
    private final boolean mbn;

    public static e dqT() {
        return mbo;
    }

    public static e dqU() {
        return mbp;
    }

    public static e dqV() {
        return mbq;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mbn = z;
    }

    public boolean dqW() {
        return this.mRotation == -1;
    }

    public boolean dqX() {
        return this.mRotation != -2;
    }

    public int dqY() {
        if (dqW()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dqZ() {
        return this.mbn;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mbn));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mbn == eVar.mbn;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mbn));
    }
}
