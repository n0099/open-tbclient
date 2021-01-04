package com.facebook.imagepipeline.common;
/* loaded from: classes6.dex */
public class e {
    private static final e pAK = new e(-1, false);
    private static final e pAL = new e(-2, false);
    private static final e pAM = new e(-1, true);
    private final int mRotation;
    private final boolean pAJ;

    public static e exk() {
        return pAK;
    }

    public static e exl() {
        return pAM;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pAJ = z;
    }

    public boolean exm() {
        return this.mRotation == -1;
    }

    public boolean exn() {
        return this.mRotation != -2;
    }

    public int exo() {
        if (exm()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean exp() {
        return this.pAJ;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pAJ));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pAJ == eVar.pAJ;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pAJ));
    }
}
