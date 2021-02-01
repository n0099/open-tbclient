package com.facebook.imagepipeline.common;
/* loaded from: classes5.dex */
public class e {
    private static final e pHZ = new e(-1, false);
    private static final e pIa = new e(-2, false);
    private static final e pIb = new e(-1, true);
    private final int mRotation;
    private final boolean pHY;

    public static e ewm() {
        return pHZ;
    }

    public static e ewn() {
        return pIb;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.pHY = z;
    }

    public boolean ewo() {
        return this.mRotation == -1;
    }

    public boolean ewp() {
        return this.mRotation != -2;
    }

    public int ewq() {
        if (ewo()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean ewr() {
        return this.pHY;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.pHY));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.pHY == eVar.pHY;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.pHY));
    }
}
