package com.facebook.imagepipeline.common;
/* loaded from: classes5.dex */
public class e {
    private static final e pCr = new e(-1, false);
    private static final e pCs = new e(-2, false);
    private static final e pCt = new e(-1, true);
    private final int mRotation;
    private final boolean pCq;

    public static e exM() {
        return pCr;
    }

    public static e exN() {
        return pCt;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pCq = z;
    }

    public boolean exO() {
        return this.mRotation == -1;
    }

    public boolean exP() {
        return this.mRotation != -2;
    }

    public int exQ() {
        if (exO()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean exR() {
        return this.pCq;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pCq));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pCq == eVar.pCq;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pCq));
    }
}
