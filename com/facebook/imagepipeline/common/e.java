package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mwt = new e(-1, false);
    private static final e mwu = new e(-2, false);
    private static final e mwv = new e(-1, true);
    private final int mRotation;
    private final boolean mws;

    public static e dyx() {
        return mwt;
    }

    public static e dyy() {
        return mwu;
    }

    public static e dyz() {
        return mwv;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mws = z;
    }

    public boolean dyA() {
        return this.mRotation == -1;
    }

    public boolean dyB() {
        return this.mRotation != -2;
    }

    public int dyC() {
        if (dyA()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dyD() {
        return this.mws;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mws));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mws == eVar.mws;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mws));
    }
}
