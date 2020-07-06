package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mSw = new e(-1, false);
    private static final e mSx = new e(-2, false);
    private static final e mSy = new e(-1, true);
    private final int mRotation;
    private final boolean mSv;

    public static e dDd() {
        return mSw;
    }

    public static e dDe() {
        return mSx;
    }

    public static e dDf() {
        return mSy;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mSv = z;
    }

    public boolean dDg() {
        return this.mRotation == -1;
    }

    public boolean dDh() {
        return this.mRotation != -2;
    }

    public int dDi() {
        if (dDg()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dDj() {
        return this.mSv;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mSv));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mSv == eVar.mSv;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mSv));
    }
}
