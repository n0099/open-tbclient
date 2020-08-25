package com.facebook.imagepipeline.common;
/* loaded from: classes8.dex */
public class e {
    private static final e nuu = new e(-1, false);
    private static final e nuv = new e(-2, false);
    private static final e nuw = new e(-1, true);
    private final int mRotation;
    private final boolean nut;

    public static e dSp() {
        return nuu;
    }

    public static e dSq() {
        return nuv;
    }

    public static e dSr() {
        return nuw;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.nut = z;
    }

    public boolean dSs() {
        return this.mRotation == -1;
    }

    public boolean dSt() {
        return this.mRotation != -2;
    }

    public int dSu() {
        if (dSs()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dSv() {
        return this.nut;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.nut));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.nut == eVar.nut;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.nut));
    }
}
