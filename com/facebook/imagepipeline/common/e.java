package com.facebook.imagepipeline.common;
/* loaded from: classes5.dex */
public class e {
    private static final e pKE = new e(-1, false);
    private static final e pKF = new e(-2, false);
    private static final e pKG = new e(-1, true);
    private final int mRotation;
    private final boolean pKD;

    public static e ewD() {
        return pKE;
    }

    public static e ewE() {
        return pKG;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pKD = z;
    }

    public boolean ewF() {
        return this.mRotation == -1;
    }

    public boolean ewG() {
        return this.mRotation != -2;
    }

    public int ewH() {
        if (ewF()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean ewI() {
        return this.pKD;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pKD));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pKD == eVar.pKD;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pKD));
    }
}
