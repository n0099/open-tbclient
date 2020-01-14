package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e lRb = new e(-1, false);
    private static final e lRc = new e(-2, false);
    private static final e lRd = new e(-1, true);
    private final boolean lRa;
    private final int mRotation;

    public static e dnh() {
        return lRb;
    }

    public static e dni() {
        return lRc;
    }

    public static e dnj() {
        return lRd;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lRa = z;
    }

    public boolean dnk() {
        return this.mRotation == -1;
    }

    public boolean dnl() {
        return this.mRotation != -2;
    }

    public int dnm() {
        if (dnk()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dnn() {
        return this.lRa;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRa));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lRa == eVar.lRa;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRa));
    }
}
