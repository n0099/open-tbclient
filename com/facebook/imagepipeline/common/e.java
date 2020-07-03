package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mSt = new e(-1, false);
    private static final e mSu = new e(-2, false);
    private static final e mSv = new e(-1, true);
    private final int mRotation;
    private final boolean mSs;

    public static e dCZ() {
        return mSt;
    }

    public static e dDa() {
        return mSu;
    }

    public static e dDb() {
        return mSv;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mSs = z;
    }

    public boolean dDc() {
        return this.mRotation == -1;
    }

    public boolean dDd() {
        return this.mRotation != -2;
    }

    public int dDe() {
        if (dDc()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dDf() {
        return this.mSs;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mSs));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mSs == eVar.mSs;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mSs));
    }
}
